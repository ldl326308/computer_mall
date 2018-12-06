package com.nf.lc.exception;

//没有数据抛出的异常
public class EmptyException extends Exception {
    public EmptyException(String message) {
        super(message);
    }

    public EmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
