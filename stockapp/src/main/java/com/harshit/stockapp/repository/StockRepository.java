package com.harshit.stockapp.repository;

import com.harshit.stockapp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}