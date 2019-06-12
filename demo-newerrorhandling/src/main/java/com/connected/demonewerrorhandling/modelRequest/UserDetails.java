package com.connected.demonewerrorhandling.modelRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDetails {
    @Size(min = 2, message = "must not be less than 2 characters")
    private String firstName;
    @Size(min = 2, message = "must not be less than 2 characters")
    private String lastName;
    @Email
    private String email;
    @Size(min = 7,max = 16, message = "must be equal or greater than 8 characters and less than 16 characters")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
