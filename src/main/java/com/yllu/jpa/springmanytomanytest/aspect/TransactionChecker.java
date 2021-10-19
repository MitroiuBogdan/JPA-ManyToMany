package com.yllu.jpa.springmanytomanytest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
@Aspect
public class TransactionChecker {

    @Around("@annotation(com.yllu.jpa.springmanytomanytest.aspect.SyncTransaction)")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronization synchronization = new TransactionSynchronization() {
                @Override
                public void afterCommit() {

                    try {
                        proceedingJoinPoint.proceed();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }

                }
            };
            TransactionSynchronizationManager.registerSynchronization(synchronization);
        } else {
            proceedingJoinPoint.proceed();
        }
    }
}
