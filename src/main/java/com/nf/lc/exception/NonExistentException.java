package com.nf.lc.exception;

//没有找到异常
public class NonExistentException extends Exception {

    public NonExistentException(String message) {
        super(message);
    }

    public NonExistentException(String message, Throwable cause) {
        super(message, cause);
    }
}
