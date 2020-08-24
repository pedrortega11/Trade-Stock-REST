package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.domain.Stock;

/**
 * Stock service interface, that provides the operations
 * for calculating dividends, ratios, prices and indexes.
 * <p>
 * Also provides operations for storing and retrieving
 * stocks from the underlying repository.
 */
public interface StockService {

    /**
     * Records a stock into the underlying repository.
     *
     * @param stock Stock
     */
    void recordStock(Stock stock);

    /**
     * Retrieves stock details from the underlying repository.
     *
     * @param stockSymbol stock symbol
     * @return Stock details
     */
    Stock retrieveStock(String stockSymbol);
}
