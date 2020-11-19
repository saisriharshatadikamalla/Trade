package com.example.springbootswagger2.model;

public class Output {
  
  public String getStockSymbol() {
    return stockSymbol;
  }
  
  public void setStockSymbol(String stockSymbol) {
    this.stockSymbol = stockSymbol;
  }
  
  public double getHighPrice() {
    return highPrice;
  }
  
  public void setHighPrice(int highPrice) {
    this.highPrice = highPrice;
  }
  
  public double getLowPrice() {
    return lowPrice;
  }
  
  public void setLowPrice(int lowPrice) {
    this.lowPrice = lowPrice;
  }
  
  String stockSymbol;
  
  public Output(String stockSymbol, double highPrice, double lowPrice) {
    this.stockSymbol = stockSymbol;
    this.highPrice = highPrice;
    this.lowPrice = lowPrice;
  }
  
  double highPrice;
  
  double lowPrice;
  
}
