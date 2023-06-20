package com.example.demo.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class ShortUrlException extends RuntimeException {

    private final Map<String, String> validation = new HashMap<>();

    public ShortUrlException(String message) {
        super(message);
    }

    public ShortUrlException(String message, Throwable cause) {
        super(message, cause);
    }
    public void addValidation(String filedName, String message) {
        validation.put(filedName, message);
    }
    public abstract int getStatusCode();
}
