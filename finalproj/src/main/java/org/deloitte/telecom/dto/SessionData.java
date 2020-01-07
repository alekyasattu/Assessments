package org.deloitte.telecom.dto;

import org.deloitte.telecom.entities.*;
import org.springframework.stereotype.Component;

public class SessionData {

    private Account customer;

    public void setUser(Account customer){
        this.customer=customer;
    }

    public Account getUser(){
        return customer;
    }




}
