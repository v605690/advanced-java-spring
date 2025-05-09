package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private String email;
    private String phoneNumber;

    public Contact(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
