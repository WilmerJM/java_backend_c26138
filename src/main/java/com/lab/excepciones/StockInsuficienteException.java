package com.lab.excepciones;

public class StockInsuficienteException extends RuntimeException{

    public StockInsuficienteException(String message) {
        super(message);
    }
}
