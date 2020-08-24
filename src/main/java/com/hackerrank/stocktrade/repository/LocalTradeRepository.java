package com.hackerrank.stocktrade.repository;

import com.hackerrank.stocktrade.domain.Trade;
import org.springframework.stereotype.Repository;

@Repository
public class LocalTradeRepository extends LocalRepository<Trade> {

    public LocalTradeRepository() {
        super();
    }

}
