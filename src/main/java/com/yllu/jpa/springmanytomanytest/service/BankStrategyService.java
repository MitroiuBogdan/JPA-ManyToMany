package com.yllu.jpa.springmanytomanytest.service;

import com.yllu.jpa.springmanytomanytest.model.Bank;
import com.yllu.jpa.springmanytomanytest.publishers.EventPublisher;
import com.yllu.jpa.springmanytomanytest.publishers.SimplePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankStrategyService {
//    @Autowired
//    EventPublisher eventPublisher;

    @Autowired
    SimplePublisher eventPublisher;
    @Autowired
    BankService bankService;

    @Autowired
    SoftDeleteService softDeleteService;

    @Transactional
    public void process(List<Bank> banks) {

        softDeleteService.softDelete();

        eventPublisher.publish();
        bankService.save(banks.get(0));
        eventPublisher.publish();
        bankService.save(banks.get(1));
        eventPublisher.publish();
        bankService.save(banks.get(2));


    }

}
