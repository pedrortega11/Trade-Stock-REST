package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.domain.Stock;


public interface StockService {

    void recordStock(Stock stock);

    Stock retrieveStock(String stockSymbol);
}
