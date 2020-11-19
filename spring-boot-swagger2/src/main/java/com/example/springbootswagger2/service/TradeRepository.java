package com.example.springbootswagger2.service;

import com.example.springbootswagger2.model.Trade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>, JpaSpecificationExecutor<Trade>, PagingAndSortingRepository<Trade, Long> {
  
  // List<T> findAll(Sort sort);
  boolean existsById(int id);
  
  boolean existsBySymbol(String symbol);
  
  public List<Trade> findAllByOrderByIdAsc();
  
  public List<Trade> findAllByUserIdOrderByIdAsc(int id);
  
  
  public List<Trade> findAllByTypeAndSymbolOrderByIdAsc(String type, String symbol);
  
  public List<Trade> findAllBySymbol(String symbol);
  
}
