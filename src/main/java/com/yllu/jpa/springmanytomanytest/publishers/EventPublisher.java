package com.yllu.jpa.springmanytomanytest.publishers;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class EventPublisher {

    private final SimplePublisher simplePublisher;

    public EventPublisher(SimplePublisher simplePublisher) {
        this.simplePublisher = simplePublisher;
    }


    public void publish() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            publishAfterCommit();
        } else {
            simplePublisher.publish();
        }
    }

    private void publishAfterCommit() {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                simplePublisher.publish();
            }
        });
    }

}