package com.hackerrank.stocktrade.spec;

import com.hackerrank.stocktrade.domain.Stock;

import java.util.function.Predicate;

/**
 * Factory for trade specifications.
 */
public class StockSpecification {

    public static Predicate<Stock> withSymbol(String symbol) {
        return stock -> stock.getSymbol().equals(symbol);
    }

}
