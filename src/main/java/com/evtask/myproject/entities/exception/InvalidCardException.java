package com.evtask.myproject.entities.exception;

public class InvalidCardException extends RuntimeException {
    public InvalidCardException(String msg){
        super(msg);
    }
}
