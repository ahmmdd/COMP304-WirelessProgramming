package com.cc.mja.intentusesamplelab1;

import java.io.Serializable;

/**
 * Created by t875341 on 26/09/2016.
 */
public class Student implements Serializable {
    private String firstName;
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
