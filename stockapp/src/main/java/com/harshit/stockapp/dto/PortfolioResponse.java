package com.harshit.stockapp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioResponse {

    private String stockName;
    private int quantity;
    private double buyPrice;
    private double currentPrice;
    private double profit;
}