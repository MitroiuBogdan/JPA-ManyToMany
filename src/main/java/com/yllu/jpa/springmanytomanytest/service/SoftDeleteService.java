package com.yllu.jpa.springmanytomanytest.service;

import com.yllu.jpa.springmanytomanytest.publishers.EventPublisher;
import com.yllu.jpa.springmanytomanytest.publishers.SimplePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SoftDeleteService {

    @Autowired
    SimplePublisher eventPublisher;

    public void softDelete() {
        eventPublisher.publish();
    }


}
