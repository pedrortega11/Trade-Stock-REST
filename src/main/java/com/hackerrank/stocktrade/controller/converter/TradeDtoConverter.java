package com.hackerrank.stocktrade.controller.converter;

import com.hackerrank.stocktrade.controller.api.TradeDto;
import com.hackerrank.stocktrade.domain.Trade;
import com.hackerrank.stocktrade.domain.TradeIndicator;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

/**
 * Converts a Trade DTO into a Trade from the internal domain.
 */
@Component
public class TradeDtoConverter implements Function<TradeDto, Trade> {
    @Override
    public Trade apply(TradeDto tradeDto) {
        double price = tradeDto.getPrice();
        int quantity = tradeDto.getQuantity();
        String stockSymbol = tradeDto.getStockSymbol();
        TradeIndicator indicator = TradeIndicator.valueOf(tradeDto.getIndicator());

        return new Trade(
                new Date().getTime(),
                price, quantity, stockSymbol, indicator);
    }
}
