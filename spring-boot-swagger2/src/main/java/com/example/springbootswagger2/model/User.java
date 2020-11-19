package com.example.springbootswagger2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "User")
public class User extends BaseEntity {
  
  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
 /* @Id
  @Column(name = "Uniqueid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int uniqueId;*/
  
  @Id
  @Column(name = "ID")
  private int id;
  
  @Column(name = "Name")
  private String name;
  
  public User() {
  }
  
  public User(String name) {
   
    this.name = name;
  }
  
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  
}