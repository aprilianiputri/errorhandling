package com.connected.demonewerrorhandling.modelResponse;

import lombok.Getter;

@Getter
public class DeleteResponse {
    private String mssg;

    public DeleteResponse(String mssg){
        this.mssg = mssg;
    }
}
