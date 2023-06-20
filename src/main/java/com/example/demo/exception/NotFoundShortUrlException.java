package com.example.demo.exception;

public class NotFoundShortUrlException extends ShortUrlException{

    private static final String MESSAGE = "잘못된 URL 입니다.";

    public NotFoundShortUrlException() {
        super(MESSAGE);
    }

    public NotFoundShortUrlException(Throwable cause) {
        super(MESSAGE, cause);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
