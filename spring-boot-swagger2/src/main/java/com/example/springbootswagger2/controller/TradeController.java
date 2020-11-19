package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.dto.TradeDto;
import com.example.springbootswagger2.exceptions.TradeServiceBaseException;
import com.example.springbootswagger2.model.Output;
import com.example.springbootswagger2.model.Trade;
import com.example.springbootswagger2.service.TradeRepository;
import com.example.springbootswagger2.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "TradeController", description = "REST Apis related to Trade Entity!!!!")
@RestController
public class TradeController {
  
  @Autowired
  private TradeRepository tradeRepository;
  
  Logger logger = LoggerFactory.getLogger(TradeController.class);
  
  @Autowired
  private TradeService tradeService;
  
  @ApiOperation("Create Trade")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "OK - Trade created successfully"),
      @ApiResponse(code = 400, message = "Trade already exists.")
  })
  @PostMapping(value = "/trades", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createTrade(@ApiParam(name = "tradeDto") @RequestBody TradeDto tradeDto) {
    try {
      
      if (tradeService.createTrade(CommonUtils.convertToEntity(tradeDto, new Trade()))) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Trade Created");
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Trade already exists");
      }
      
    } catch (TradeServiceBaseException e) {
      logger.error(e.getMessage(), e);
      return ResponseEntity
          .status(e.getStatus())
          .body(e.getMessage());
    }
  }
  
  @ApiOperation("Delete all Trades")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "OK - Trade deleted successfully"),
  })
  @DeleteMapping("/trades")
  public ResponseEntity<String> deleteAllTrades() throws TradeServiceBaseException {
    
    try {
      return ResponseEntity.status(HttpStatus.OK).body(tradeService.deleteAllTrades());
    } catch (TradeServiceBaseException e) {
      logger.error(e.getMessage(), e);
      return ResponseEntity
          .status(e.getStatus())
          .body(e.getMessage());
    }
  }
  
  @ApiOperation("Get all Trades")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "OK - Got all trades"),
  })
  @GetMapping("/trades")
  public ResponseEntity<List<Trade>> getAllTrades() throws TradeServiceBaseException {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(tradeService.getAllTrades());
    } catch (TradeServiceBaseException e) {
      logger.error(e.getMessage(), e);
      return null;
    }
  }
  
  @ApiOperation("Get Trades by user id")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "OK - Trade created successfully"),
      @ApiResponse(code = 400, message = "User donot exist")
  })
  @GetMapping("/trades/users/{userID}")
  @ResponseBody
  public ResponseEntity getAllTradesbyUserId(@PathVariable(value = "userID") int userId) throws TradeServiceBaseException {
    try {
      if (tradeService.getAllTradesbyUserId(userId) != null) {
        return ResponseEntity.status(HttpStatus.OK).body(tradeService.getAllTradesbyUserId(userId));
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User doesnt exist");
      }
    } catch (TradeServiceBaseException e) {
      logger.error(e.getMessage(), e);
      return null;
    }
    
  }
  
  @ApiOperation("Get Trades by between Date Range")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "OK - Trade created successfully"),
      @ApiResponse(code = 400, message = "User donot exist")
  })
  @GetMapping("/stocks/{stockSymbol}/trades")
  @ResponseBody
  public ResponseEntity getAllTradesbyDate(@PathVariable(value = "stockSymbol") String symbol, @RequestParam("type") String type, @RequestParam("start") String start, @RequestParam("end") String end) throws TradeServiceBaseException, ParseException {
    
    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(start);
    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end);
    if (tradeService.findTradeBySymbol(symbol)) {
      return ResponseEntity.status(HttpStatus.OK).body(tradeService.findAllByTypeAndSymbolOrderByIdAsc(type, symbol, date1, date2));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Symbol doesnt exist");
    }
    
    
  }
  
  @ApiOperation("Get Trades Price")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "OK - Trade created successfully"),
  })
  @GetMapping("/stocks/{stockSymbol}/price")
  @ResponseBody
  public ResponseEntity<Output> getPrice(@PathVariable(value = "stockSymbol") String stockSymbol, @RequestParam("start") String start, @RequestParam("end") String end) throws TradeServiceBaseException, ParseException {
    
    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(start);
    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end);
    
    
    return ResponseEntity.status(HttpStatus.OK).body(tradeService.findTradebyPrice(stockSymbol, date1, date2));
    
  }
  
  
}
