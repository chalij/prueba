package com.ejemplos.exception;

public class DAOException extends Exception {

    /**
     * @param errorMessage
     * @param throwable
     */
    public DAOException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    /**
     * @param errorMessage
     */
    public DAOException(String errorMessage) {
        super(errorMessage);
    }
}