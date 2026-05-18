package com.harshit.stockapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.stockapp.model.Stock;
import com.harshit.stockapp.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository repo;

    public Stock addStock(Stock stock) {
        return repo.save(stock);
    }

    public List<Stock> getAllStocks() {
        return repo.findAll();
    }
}