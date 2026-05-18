package com.harshit.stockapp.controller;

import com.harshit.stockapp.model.Stock;
import com.harshit.stockapp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return service.addStock(stock);
    }

    @GetMapping
    public List<Stock> getStocks() {
        return service.getAllStocks();
    }
}