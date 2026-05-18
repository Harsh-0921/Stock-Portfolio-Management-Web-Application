    package com.harshit.stockapp.service;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.harshit.stockapp.model.Portfolio;
    import com.harshit.stockapp.repository.PortfolioRepository;
    import com.harshit.stockapp.dto.PortfolioResponse;
    import java.util.ArrayList;

    @Service
    public class PortfolioService {

        @Autowired
        private PortfolioRepository repo;

        public Portfolio buyStock(Long userId, Long stockId, int qty, double price) {

            List<Portfolio> list = repo.findByUserId(userId);

            for (Portfolio p : list) {
                if (p.getStockId().equals(stockId)) {

                    int totalQty = p.getQuantity() + qty;

                    double avgPrice =
                            ((p.getBuyPrice() * p.getQuantity()) + (price * qty)) / totalQty;

                    p.setQuantity(totalQty);
                    p.setBuyPrice(avgPrice);

                    return repo.save(p);
                }
            }

            

            Portfolio newStock = new Portfolio();
            newStock.setUserId(userId);
            newStock.setStockId(stockId);
            newStock.setQuantity(qty);
            newStock.setBuyPrice(price);

            return repo.save(newStock);
        }
    public Portfolio sellStock(Long userId, Long stockId, int qty) {

        List<Portfolio> list = repo.findByUserId(userId);

        for (Portfolio p : list) {
            if (p.getStockId().equals(stockId)) {

                if (p.getQuantity() < qty) {
                    throw new RuntimeException("Not enough stock");
                }

                p.setQuantity(p.getQuantity() - qty);

                return repo.save(p);
            }
        }

        throw new RuntimeException("Stock not found");
    }

    public List<PortfolioResponse> getPortfolio(Long userId) {

        List<Portfolio> list = repo.findByUserId(userId);
        List<PortfolioResponse> response = new ArrayList<>();

        for (Portfolio p : list) {

            double currentPrice = priceService.getStockPrice("TCS");
            
            double profit = calculateProfit(
                    p.getBuyPrice(),
                    currentPrice,
                    p.getQuantity()
            );

            PortfolioResponse res = new PortfolioResponse(
                    "Stock-" + p.getStockId(),
                    p.getQuantity(),
                    p.getBuyPrice(),
                    currentPrice,
                    profit
            );

            response.add(res);
        }

        return response;
    }
    public double calculateProfit(double buyPrice, double currentPrice, int qty) {
        return (currentPrice - buyPrice) * qty;
    }
    @Autowired
    private StockPriceService priceService;

    }