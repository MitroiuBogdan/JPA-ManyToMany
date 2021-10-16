package com.yllu.jpa.springmanytomanytest.service;

import com.yllu.jpa.springmanytomanytest.model.Client;
import com.yllu.jpa.springmanytomanytest.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public Client save(Client client) {
        String id = client.getId();
        if (client.getId() == null) {
            id = UUID.randomUUID().toString();
        }
        System.out.println("Saving client with name: " + client.getName() + " and id: " + id);
        client.setId(id);
        return clientRepository.save(client);
    }

    public Client getById(String id) {
        return clientRepository.findById(id).orElse(null);
    }
}
