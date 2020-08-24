package com.hackerrank.stocktrade.controller.converter;

import com.hackerrank.stocktrade.controller.api.StockDto;
import com.hackerrank.stocktrade.domain.Stock;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StockConverter implements Function<Stock, StockDto> {
    @Override
    public StockDto apply(Stock stock) {
        StockDto stockDto = new StockDto();

        stockDto.setSymbol(stock.getSymbol());
        stockDto.setType(stock.getType().name());
        stockDto.setFixedDividend(stock.getFixedDividend());
        stockDto.setLastDividend(stock.getLastDividend());
        stockDto.setParValue(stock.getParValue());
        stockDto.setTickerPrice(stock.getTickerPrice());

        return stockDto;
    }
}
