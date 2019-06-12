package com.connected.demonewerrorhandling.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("Can't find the user id");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
