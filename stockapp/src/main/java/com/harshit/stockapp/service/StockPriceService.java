package com.harshit.stockapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class StockPriceService {

    private final String API_KEY = "YOUR_API_KEY";

    public double getStockPrice(String symbol) {

        try {
            String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="
                    + symbol + "&apikey=" + API_KEY;

            RestTemplate restTemplate = new RestTemplate();

            Map<String, Object> response =
                    restTemplate.getForObject(url, Map.class);

            if (response == null || response.get("Global Quote") == null) {
                return 0;
            }

            Map<String, String> quote =
                    (Map<String, String>) response.get("Global Quote");

            if (quote.get("05. price") == null) {
                return 0;
            }

            return Double.parseDouble(quote.get("05. price"));

        } catch (Exception e) {
            System.out.println("API Error: " + e.getMessage());
            return 0;
        }
    }
}