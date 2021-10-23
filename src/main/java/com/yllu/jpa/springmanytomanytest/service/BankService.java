package com.yllu.jpa.springmanytomanytest.service;

import com.yllu.jpa.springmanytomanytest.model.Bank;
import com.yllu.jpa.springmanytomanytest.model.Client;
import com.yllu.jpa.springmanytomanytest.repository.BankRepository;
import com.yllu.jpa.springmanytomanytest.specification.BankSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank save(Bank bank) {
        String id = bank.getId();
        if (bank.getId() == null) {
            id = UUID.randomUUID().toString();
        }
        System.out.println("Saving bank with name: " + bank.getName() + " and id: " + id);
        bank.setId(id);
        return bankRepository.save(bank);
    }

    public Bank getById(String id) {
        return bankRepository.findById(id).orElse(null);
    }

    public List<Bank> getByName(String name) {
        return bankRepository.findAll(BankSpecification.getByName(name));
    }

    public List<Bank> getByClientId(String clientId) {
        return bankRepository.findAll(
                BankSpecification.getByClientId(clientId));
    }

    public List<Bank> getByClientIdAndName(String clientId, String name) {
        return bankRepository.findAll(BankSpecification.getByClientIdAndName(clientId, name));
    }
}
