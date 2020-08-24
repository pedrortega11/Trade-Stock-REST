package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.domain.Stock;
import com.hackerrank.stocktrade.domain.Trade;
import com.hackerrank.stocktrade.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

import static com.hackerrank.stocktrade.spec.StockSpecification.withSymbol;
import static com.hackerrank.stocktrade.spec.TradeSpecification.forStock;
import static com.hackerrank.stocktrade.spec.TradeSpecification.within;

@Service
public class StockServiceImpl implements StockService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);

    private final GenericRepository<Stock> stockRepository;
    private final GenericRepository<Trade> tradeRepository;

    @Value("${stocks.stockprice.tradeTimeRangeMinutes}")
    private int stockPriceRangeMins;

    @Autowired
    public StockServiceImpl(GenericRepository<Stock> stockRepository, GenericRepository<Trade> tradeRepository) {
        this.stockRepository = stockRepository;
        this.tradeRepository = tradeRepository;
    }

    @Override
    public void recordStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public Stock retrieveStock(String stockSymbol) {
        Stock stock = stockRepository.findOne(withSymbol(stockSymbol));

        // return stock details if it exists
        return validateStock(stockSymbol, stock);
    }

    private Stock validateStock(String stockSymbol, Stock stock) {
        if (stock != null) {
            // return PE ratio if stock exists
            LOGGER.debug("Found stock {}", stock);
            return stock;
        } else {
            LOGGER.warn("Could not find any stock for symbol {}", stockSymbol);
            throw new ServiceException("stock not found");
        }
    }

    Double calculateStockPriceFromPastMinutes(String stockSymbol, int offsetMinutes) {
        // retrieve trades for a specific stock symbol from the past minutes
        Date now = new Date();

        Collection<Trade> trades = tradeRepository.findAll(
                forStock(stockSymbol)
        );

        if (trades.isEmpty()) {
            LOGGER.warn("Could not find any stock for symbol {} within last {} minutes", stockSymbol, offsetMinutes);
            throw new ServiceException("trades not found");
        }

        LOGGER.debug("Found trades {}", trades);

        // sum the product tradePrice*quantity
        double productSum = trades.stream()
                .map(t -> t.getPrice() * t.getQuantity())
                .mapToDouble(Double::doubleValue)
                .sum();

        // sum the quantity
        int quantitySum = trades.stream()
                .map(Trade::getQuantity)
                .mapToInt(Integer::intValue)
                .sum();

        // calculate stock price for from past minutes if quantity sum greater than zero
        if (quantitySum == 0) {
            LOGGER.warn("Quantity sum is zero for stock symbol {} within last {} minutes", stockSymbol, offsetMinutes);
            throw new ServiceException("quantity sum is zero");
        }

        return productSum / quantitySum;
    }

}
