package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.controller.api.*;
import com.hackerrank.stocktrade.controller.converter.StockConverter;
import com.hackerrank.stocktrade.controller.converter.StockDtoConverter;
import com.hackerrank.stocktrade.domain.Stock;
import com.hackerrank.stocktrade.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

	
    private final StockService stockService;
    private final StockDtoConverter stockDtoConverter;
    private final StockConverter stockConverter;

    @Autowired
    public StockController(StockService stockService, StockDtoConverter stockDtoConverter, StockConverter stockConverter) {
        this.stockService = stockService;
        this.stockDtoConverter = stockDtoConverter;
        this.stockConverter = stockConverter;
    }

    @RequestMapping(value = "/stock", method = RequestMethod.POST)
    public ResponseEntity<String> postStock(@RequestBody StockDto stockDto) {
        Stock stock = stockDtoConverter.apply(stockDto);
        stockService.recordStock(stock);
        return ResponseEntity.ok("Stock added with success");
    }

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public StockDto getStock(@RequestParam String symbol) {
        Stock stock = stockService.retrieveStock(symbol);
        return stockConverter.apply(stock);
    }

}