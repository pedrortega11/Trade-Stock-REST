package com.hackerrank.stocktrade.service;

/**
 * Exception to be thrown when a service error occurs.
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

}
