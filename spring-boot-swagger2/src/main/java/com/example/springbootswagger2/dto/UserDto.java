package com.example.springbootswagger2.dto;


import com.example.springbootswagger2.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Request Object for the User")
public class UserDto  extends BaseDto {
  
  @ApiModelProperty(" id for Trade")
  @JsonProperty("id")
  private int id ;
  
  @ApiModelProperty("name")
  @JsonProperty("name")
  private String name;
  
  public UserDto() {
  }
  
  
}
