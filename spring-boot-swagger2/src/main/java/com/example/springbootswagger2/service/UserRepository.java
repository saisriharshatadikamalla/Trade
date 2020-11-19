package com.example.springbootswagger2.service;

import com.example.springbootswagger2.model.Trade;
import com.example.springbootswagger2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<Trade>, PagingAndSortingRepository<User,Long> {
  
  // List<T> findAll(Sort sort);
  boolean existsById(int id);
  User findUserByName(String username);
  
}
