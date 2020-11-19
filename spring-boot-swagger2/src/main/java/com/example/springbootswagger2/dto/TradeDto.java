package com.example.springbootswagger2.dto;


import com.example.springbootswagger2.dto.BaseDto;
import com.example.springbootswagger2.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
@ApiModel(description = "Request Object for the Trade")

public class TradeDto extends BaseDto {
  
  @ApiModelProperty(" id for Trade")
  @JsonProperty("id")
  private int id;
  
  @ApiModelProperty(" Type for Trade")
  @JsonProperty("type")
  private String type;
  
  @ApiModelProperty("user Id for Trade")
  @JsonProperty("user")
  User user;
  
  
  @ApiModelProperty("symbol for Trade")
  @JsonProperty("symbol")
  private String symbol;
  
  
  @ApiModelProperty("shares for Trade")
  @JsonProperty("shares")
  private String shares;
  
  @ApiModelProperty("price for Trade")
  @JsonProperty("price")
  private double price;
  
  @ApiModelProperty("timestamp for Trade")
  @JsonProperty("timestamp")
  private Date timestamp;
  
  
  public TradeDto() {
  }
  
}
