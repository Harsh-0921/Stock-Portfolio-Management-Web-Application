package com.harshit.stockapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.harshit.stockapp.model.Portfolio;
import com.harshit.stockapp.service.PortfolioService;
import com.harshit.stockapp.dto.PortfolioResponse;
import java.util.List;
 
@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService service;

    @PostMapping("/buy")
    public Portfolio buy(@RequestParam Long userId,
                         @RequestParam Long stockId,
                         @RequestParam int qty,
                         @RequestParam double price) {

        return service.buyStock(userId, stockId, qty, price);
    }

    @PostMapping("/sell")
    public Portfolio sell(@RequestParam Long userId,
                          @RequestParam Long stockId,
                          @RequestParam int qty) {

        return service.sellStock(userId, stockId, qty);
    }
    @GetMapping("/{userId}")
public List<PortfolioResponse> getPortfolio(@PathVariable Long userId) {
    return service.getPortfolio(userId);
}
}