package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
public class SpecialUser extends User {
 
    public SpecialUser(String firstname, String lastname, Integer age) {
        super(firstname, lastname, age);
    }
}