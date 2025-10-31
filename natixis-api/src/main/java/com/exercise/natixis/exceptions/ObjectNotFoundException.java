package com.exercise.natixis.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super("ID: " + msg + ". Object not found! ");
    }

}