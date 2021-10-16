package com.yllu.jpa.springmanytomanytest;

import com.yllu.jpa.springmanytomanytest.model.Bank;
import com.yllu.jpa.springmanytomanytest.model.Bank_Client;
import com.yllu.jpa.springmanytomanytest.model.Client;
import com.yllu.jpa.springmanytomanytest.service.BankService;
import com.yllu.jpa.springmanytomanytest.service.Bank_ClientService;
import com.yllu.jpa.springmanytomanytest.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
/*
0793fb08-290b-44fd-9423-8cff4127c4d1	CEC
58066800-0f52-469e-808e-7f1cb47047b4	ING
650c5a46-e188-4c40-a9f6-08dbd4bb0550	Transilvania
dde67f9c-cc64-4adf-a6ba-cb99e3ac5b67	BRD
e8739c79-5af8-43c9-9cda-b7d1a0a0e818	Revolut
edb2b087-fa13-403d-9db6-dda0ecc59538	BCR

 */

/*
44792924-4b55-4a1a-88ea-e644c57d3d3e	Apple
83314d5e-bf8b-4666-a75a-0a96822041cf	Renault
9666db26-5daf-45a6-a232-0ebc8fb33efa	Amazon
b0f4fe10-79aa-4c6f-9854-4fc8b119a58e	Tesla
c6d9457a-d0db-42ca-95db-2c09b8a253ff	Google
c9c6dd6a-d682-41c7-882c-6dbcbccf6c31	Apple
e61134aa-b861-427d-8da2-cce2186561be	Profi

 */
@SpringBootApplication
public class SpringManyToManyTestApplication implements CommandLineRunner {

    private final ClientService clientService;
    private final BankService bankService;
    private final Bank_ClientService bank_clientService;

    public SpringManyToManyTestApplication(ClientService clientService, BankService bankService, Bank_ClientService bank_clientService) {
        this.clientService = clientService;
        this.bankService = bankService;
        this.bank_clientService = bank_clientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringManyToManyTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Bank bank = bankService.getById("dde67f9c-cc64-4adf-a6ba-cb99e3ac5b67");
        Client client = clientService.getById("83314d5e-bf8b-4666-a75a-0a96822041cf");

//
//        System.out.println(bank.getId() + " " + client.getId());
//        Set<Bank_Client> clientSet = bank.getClientBankRelationships();
//
//        Bank_Client bank_client = new Bank_Client(bank, client, "200");
//        bank_clientService.save(bank_client);

//        clientSet.add(bank_client);
//        bank.setClientBankRelationships(clientSet);

//        bankService.save(bank);
        for (Bank_Client bank_client : bank.getClientBankRelationships()) {
            System.out.println(bank_client.getBank().getId() + " " + bank_client.getClient().getId() + " " + bank_client.getRating());
        }

    }
}
