package com.example.springbootswagger2.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Trade")
public class Trade extends BaseEntity {
  
  @Id
  @Column(name = "Uniqueid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int uniqueId;
  
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name = "TYPE")
  private String type;
  
  public int getUniqueId() {
    return uniqueId;
  }
  
  public void setUniqueId(int uniqueId) {
    this.uniqueId = uniqueId;
  }
  
  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }
  
  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  @Column(name = "SYMBOL")
  private String symbol;
  
  
  public Trade(String type, User user, String symbol, String shares, double price, Date timestamp) {
    this.type = type;
    this.user = user;
    this.symbol = symbol;
    this.shares = shares;
    this.price = price;
    this.timestamp = timestamp;
  }
  
  @Column(name = "SHARES")
  private String shares;
  
  @Column(name = "PRICE")
  private double price;
  
  @Column(name = "TIMESTAMP")
  private Date timestamp;
  
  
  public Trade() {
  }
  
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String getSymbol() {
    return symbol;
  }
  
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }
  
  public String getShares() {
    return shares;
  }
  
  public void setShares(String shares) {
    this.shares = shares;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public Date getTimestamp() {
    return timestamp;
  }
  
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
  
  
}