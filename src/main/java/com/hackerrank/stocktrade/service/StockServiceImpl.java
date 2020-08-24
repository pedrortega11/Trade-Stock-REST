package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.domain.Stock;
import com.hackerrank.stocktrade.domain.Trade;
import com.hackerrank.stocktrade.repository.GenericRepository;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;


@Service
public class StockServiceImpl implements StockService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);

    private final GenericRepository<Stock> stockRepository;
    @Autowired
    public StockServiceImpl(GenericRepository<Stock> stockRepository, GenericRepository<Trade> tradeRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void recordStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public Stock retrieveStock(String stockSymbol) {
        Stock stock = stockRepository.findOne(withSymbol(stockSymbol));

        return validateStock(stockSymbol, stock);
    }

    public static Predicate<Stock> withSymbol(String symbol) {
        return stock -> stock.getSymbol().equals(symbol);
    }
    
    private Stock validateStock(String stockSymbol, Stock stock) {
        if (stock != null) {
            LOGGER.debug("Found stock {}", stock);
            return stock;
        } else {
            LOGGER.warn("Could not find any stock for symbol {}", stockSymbol);
            throw new ServiceException("stock not found");
        }
    }



}
