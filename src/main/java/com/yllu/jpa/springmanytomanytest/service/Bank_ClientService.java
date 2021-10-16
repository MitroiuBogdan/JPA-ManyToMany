package com.yllu.jpa.springmanytomanytest.service;

import com.yllu.jpa.springmanytomanytest.model.Bank;
import com.yllu.jpa.springmanytomanytest.model.Bank_Client;
import com.yllu.jpa.springmanytomanytest.model.Client;
import com.yllu.jpa.springmanytomanytest.repository.Bank_ClientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class Bank_ClientService {

    private final Bank_ClientRepository bank_clientRepository;

    public Bank_ClientService(Bank_ClientRepository bank_clientRepository) {
        this.bank_clientRepository = bank_clientRepository;
    }

    public Bank_Client save(Bank_Client bank_client) {
        String id = UUID.randomUUID().toString();
        bank_client.setId(id);
        return bank_clientRepository.save(bank_client);
    }
}
