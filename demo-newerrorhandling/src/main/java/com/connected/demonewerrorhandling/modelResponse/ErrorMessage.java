package com.connected.demonewerrorhandling.modelResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
@AllArgsConstructor
public class ErrorMessage {


    //private Date timestamp;
    private String message;
    private String[] errors;

    //public ErrorMessage (){}

    public ErrorMessage(Date timestamp, String message){
        //this.timestamp = timestamp;
        this.message = message;
    }

    /*public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }*/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    public String[] getErrors() {
        return errors;
    }
}
