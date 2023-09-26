package com.gamelibrary.exception;

import lombok.Getter;


public class CustomException extends Exception {

    int statusCode;
    public CustomException(String errorMsg,int statusCode) {
        super(errorMsg);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
