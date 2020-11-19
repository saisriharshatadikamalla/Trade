package com.example.springbootswagger2.exceptions;

import org.springframework.http.HttpStatus;


public class TradeServiceBaseException extends Exception {
  
  private HttpStatus status;
  
  public TradeServiceBaseException(Exception e) {
    super(e);
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
  }
  
  /**
   * Parameterised constructor
   *
   * @param message Message
   */
  public TradeServiceBaseException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
  
  /**
   * Parameterised constructor
   *
   * @param message Message
   */
  public TradeServiceBaseException(String message) {
    super(message);
  }
  
  public HttpStatus getStatus() {
    return status;
  }
}
