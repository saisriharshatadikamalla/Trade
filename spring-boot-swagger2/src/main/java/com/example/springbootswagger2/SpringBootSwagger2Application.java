package com.example.springbootswagger2;

import com.example.springbootswagger2.service.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSwagger2Application {
  @Autowired
  private TradeRepository tradeRepository;
  
  public static void main(String[] args) {
    SpringApplication.run(SpringBootSwagger2Application.class, args);
    
    
  }
}
