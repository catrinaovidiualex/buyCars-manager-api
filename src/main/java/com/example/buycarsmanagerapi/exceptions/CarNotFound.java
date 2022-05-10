package com.example.buycarsmanagerapi.exceptions;

public class CarNotFound extends RuntimeException {
    public CarNotFound(String message) {

        super(message);
    }
}