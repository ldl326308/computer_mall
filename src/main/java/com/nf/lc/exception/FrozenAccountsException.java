package com.nf.lc.exception;

public class FrozenAccountsException extends Exception {

    public FrozenAccountsException(String message) {
        super(message);
    }

    public FrozenAccountsException(String message, Throwable cause) {
        super(message, cause);
    }
}
