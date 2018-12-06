package com.nf.lc.exception;

//添加失败异常
public class FailureException extends Exception {

    public FailureException(String message) {
        super(message);
    }

    public FailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
