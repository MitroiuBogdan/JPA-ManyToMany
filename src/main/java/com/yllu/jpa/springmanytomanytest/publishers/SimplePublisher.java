package com.yllu.jpa.springmanytomanytest.publishers;

import com.yllu.jpa.springmanytomanytest.aspect.SyncTransaction;
import org.springframework.stereotype.Component;

@Component
public class SimplePublisher {


    @SyncTransaction
    public void publish(){
        System.out.println("EVENT HAS BEEN PUBLISHED");
    }



}
