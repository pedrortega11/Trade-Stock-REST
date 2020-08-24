package com.hackerrank.stocktrade.controller.api;

public class PERatioDto {

    private String stockSymbol;
    private Double peRatio;

    public String getStockSymbol() {
        return stockSymbol;
    }

    public Double getPeRatio() {
        return peRatio;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setPeRatio(Double peRatio) {
        this.peRatio = peRatio;
    }
}
