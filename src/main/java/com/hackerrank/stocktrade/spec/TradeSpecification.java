package com.hackerrank.stocktrade.spec;

import com.hackerrank.stocktrade.domain.Trade;

import java.util.Date;
import java.util.function.Predicate;

/**
 * Factory for trade specifications.
 */
public class TradeSpecification {

    public static Predicate<Trade> within(Date from, Date to) {
        // returns true if no time difference
        // otherwise returns true if time within range
        return trade -> from.getTime() == to.getTime()
                || (from.getTime() <= trade.getTime() && trade.getTime() < to.getTime());
    }

    public static Predicate<Trade> forStock(String stockSymbol) {
        return trade -> trade.getStockSymbol().equals(stockSymbol);
    }
}
