package com.example.springbootswagger2.controller;


import com.example.springbootswagger2.model.BaseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

public class CommonUtils {
  
  
  /**
   * Private constructor to hide implicit public one.
   */
  private CommonUtils() {
    //Empty Constructor
  }
  
  /**
   * Common method to copy properties from dto to entity
   * @param <S> source
   * @param <T> targetClass
   * @return <T> targetClass
   */
  public static <S,T extends BaseEntity> T convertToEntity(S source, T  targetClass){
    BeanUtils.copyProperties(source, targetClass);
    return targetClass;
  }
  
  public static String mapToJson(Object object) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(object);
  }
  
}
