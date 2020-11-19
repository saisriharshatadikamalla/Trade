package com.example.springbootswagger2.service;

import com.example.springbootswagger2.exceptions.TradeServiceBaseException;
import com.example.springbootswagger2.model.Output;
import com.example.springbootswagger2.model.Trade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,
    readOnly = true)
public class TradeServiceImpl implements TradeService {
  
  
  @Autowired
  private TradeRepository tradeRepository;
  
  
  @Autowired
  private UserRepository userRepository;
  
  
  @Override
  public boolean createTrade(Trade trade) throws TradeServiceBaseException {
    
    
    try {
      
      if (!tradeRepository.existsById(trade.getId())) {
        if (!userRepository.existsById(trade.getUser().getId()))
          userRepository.save(trade.getUser());
      } else {
        return false;
      }
      
      if (!userRepository.existsById(trade.getUser().getId()))
        userRepository.save(trade.getUser());
      
      tradeRepository.save(trade);
    } catch (Exception e) {
      throw new TradeServiceBaseException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
    
    return true;
    
  }
  
  
  @Override
  public List<Trade> getAllTrades() throws TradeServiceBaseException {
    
    return tradeRepository.findAllByOrderByIdAsc();
    
  }
  
  @Override
  public List<Trade> getAllTradesbyUserId(int id) throws TradeServiceBaseException {
    
    return tradeRepository.findAllByUserIdOrderByIdAsc(id);
    
  }
  
  
  @Override
  public String deleteAllTrades() throws TradeServiceBaseException {
    
    tradeRepository.deleteAll();
    
    return "Trades deletion success";
  }
  
  
  @Override
  public List<Trade> findAllByTypeAndSymbolOrderByIdAsc(String type, String symbol, Date start, Date end) {
    
    List<Trade> list = new ArrayList<>();
    list.addAll(tradeRepository.findAllByTypeAndSymbolOrderByIdAsc(type, symbol));
    
    List<Trade> result = new ArrayList<>();
    
    for (Trade t : list) {
      if (start.compareTo(t.getTimestamp()) < 0 && end.compareTo(t.getTimestamp()) > 0) {
        result.add(t);
      }
      
    }
    
    
    return result;
  }
  
  @Override
  public Output findTradebyPrice(String symbol, Date start, Date end) {
    
    double low = 0;
    double high = 0;
    
    List<Trade> list = new ArrayList<>();
    list.addAll(tradeRepository.findAllBySymbol(symbol));
    
    List<Trade> result = new ArrayList<>();
    
    for (Trade t : list) {
      if (start.compareTo(t.getTimestamp()) <= 0 && end.compareTo(t.getTimestamp()) >= 0) {
        low = Math.min(low, t.getPrice());
        high = Math.max(high, t.getPrice());
      }
      
    }
    Output output = new Output(symbol, high, low);
    
    return output;
  }
  
  @Override
  public boolean findTradeBySymbol(String symbol)
  {
   return tradeRepository.existsBySymbol(symbol);
  }
  
}