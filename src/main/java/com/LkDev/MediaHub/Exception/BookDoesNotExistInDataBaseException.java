package com.LkDev.MediaHub.Exception;

public class BookDoesNotExistInDataBaseException extends RuntimeException {
    public BookDoesNotExistInDataBaseException(String message) {
        super(message);
    }
}
