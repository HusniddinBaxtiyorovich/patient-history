package com.example.historydiseases.core.exp;

public class ServerBadRequestException extends RuntimeException {

    public ServerBadRequestException(String message) {
        super(message);
    }
}
