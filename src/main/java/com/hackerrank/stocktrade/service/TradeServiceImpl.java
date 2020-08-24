package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.domain.Trade;
import com.hackerrank.stocktrade.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {
    private final GenericRepository<Trade> tradeRepository;

    @Autowired
    public TradeServiceImpl(GenericRepository<Trade> tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public void recordTrade(Trade trade) {
        tradeRepository.save(trade);
    }
}
