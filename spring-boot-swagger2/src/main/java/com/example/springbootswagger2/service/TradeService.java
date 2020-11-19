package com.example.springbootswagger2.service;


import com.example.springbootswagger2.exceptions.TradeServiceBaseException;
import com.example.springbootswagger2.model.Output;
import com.example.springbootswagger2.model.Trade;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TradeService {
  
  boolean createTrade(Trade trade) throws TradeServiceBaseException;
  
  
  List<Trade> getAllTrades() throws TradeServiceBaseException;
  
  List<Trade> getAllTradesbyUserId(int id) throws TradeServiceBaseException;
  
  
  String deleteAllTrades() throws TradeServiceBaseException;
  
  
  List<Trade> findAllByTypeAndSymbolOrderByIdAsc(String type, String symbol, Date start, Date end);
  
  Output findTradebyPrice(String symbol, Date start, Date end);
  
  boolean findTradeBySymbol(String symbol);
}
