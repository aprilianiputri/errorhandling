package com.connected.demonewerrorhandling.modelRequest;

import javax.validation.constraints.Size;

public class UpdateUserDetail {
    @Size(min = 2, message = "must not be less than 2 characters")
    private String firstName;
    @Size(min = 2, message = "must not be less than 2 characters")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
