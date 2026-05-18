package com.harshit.stockapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.stockapp.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByUserId(Long userId);
}