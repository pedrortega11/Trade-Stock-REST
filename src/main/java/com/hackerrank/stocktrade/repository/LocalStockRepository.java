package com.hackerrank.stocktrade.repository;

import com.hackerrank.stocktrade.domain.Stock;
import org.springframework.stereotype.Repository;

@Repository
public class LocalStockRepository extends LocalRepository<Stock> {

    public LocalStockRepository() {
        super();
    }

}
