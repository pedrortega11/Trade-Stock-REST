package com.hackerrank.stocktrade.domain;

public class Stock {

    private final String symbol;
    private final StockType type;
    private final Double lastDividend;
    private final Double fixedDivided;
    private final Double parValue;
    private final Double tickerPrice;

    public Stock(String symbol,
                 StockType type,
                 double lastDividend,
                 double fixedDivided,
                 double parValue,
                 double tickerPrice) {;
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDivided = fixedDivided;
        this.parValue = parValue;
        this.tickerPrice = tickerPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public StockType getType() {
        return type;
    }

    public Double getLastDividend() {
        return lastDividend;
    }

    public Double getFixedDividend() {
        return fixedDivided;
    }

    public Double getParValue() {
        return parValue;
    }

    public Double getTickerPrice() {
        return tickerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        // symbol uniquely identifies a stock
        return symbol.equals(stock.symbol);
    }


}
