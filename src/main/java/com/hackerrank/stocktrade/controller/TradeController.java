package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.controller.api.TradeDto;
import com.hackerrank.stocktrade.controller.converter.TradeDtoConverter;
import com.hackerrank.stocktrade.domain.Trade;
import com.hackerrank.stocktrade.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);

    private final TradeService tradeService;
    private final TradeDtoConverter tradeDtoConverter;

    @Autowired
    public TradeController(TradeService tradeService, TradeDtoConverter tradeDtoConverter) {
        this.tradeService = tradeService;
        this.tradeDtoConverter = tradeDtoConverter;
    }

    @RequestMapping(value = "/trade", method = RequestMethod.POST)
    public ResponseEntity<String> postTrade(@RequestBody TradeDto tradeDto) {
        LOGGER.debug("received post trade request with data {}", tradeDto);

        Trade trade = tradeDtoConverter.apply(tradeDto);
        tradeService.recordTrade(trade);
        return ResponseEntity.ok("Trade added with success");
    }

}