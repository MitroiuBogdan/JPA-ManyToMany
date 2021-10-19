package com.yllu.jpa.springmanytomanytest;

import com.yllu.jpa.springmanytomanytest.model.Bank;
import com.yllu.jpa.springmanytomanytest.model.Bank_Client;
import com.yllu.jpa.springmanytomanytest.model.Client;
import com.yllu.jpa.springmanytomanytest.repository.BankRepository;
import com.yllu.jpa.springmanytomanytest.repository.ClientRepository;
import com.yllu.jpa.springmanytomanytest.service.BankService;
import com.yllu.jpa.springmanytomanytest.service.BankStrategyService;
import com.yllu.jpa.springmanytomanytest.service.Bank_ClientService;
import com.yllu.jpa.springmanytomanytest.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;
import java.util.Set;
/*
0793fb08-290b-44fd-9423-8cff4127c4d1	CEC
58066800-0f52-469e-808e-7f1cb47047b4	ING
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
@EnableAspectJAutoProxy
public class SpringManyToManyTestApplication implements CommandLineRunner {

    private final ClientService clientService;
    private final BankService bankService;
    private final Bank_ClientService bank_clientService;
    private final BankRepository bankRepository;
    private final ClientRepository clientRepository;
    private final BankStrategyService bankStrategyService;

    public SpringManyToManyTestApplication(ClientService clientService, BankService bankService, Bank_ClientService bank_clientService, BankRepository bankRepository, ClientRepository clientRepository, BankStrategyService bankStrategyService) {
        this.clientService = clientService;
        this.bankService = bankService;
        this.bank_clientService = bank_clientService;
        this.bankRepository = bankRepository;
        this.clientRepository = clientRepository;
        this.bankStrategyService = bankStrategyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringManyToManyTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Bank bank = bankService.getById("8e827681-d7ec-4bbf-9423-5004a8906dba");
        Client client = clientService.getById("83314d5e-bf8b-4666-a75a-0a96822041cf");

        bank.createRelation(client);

//
//        Bank bank2 = new Bank();
//
//        Bank bank3 = new Bank();
//        bank3.setName("RedBullBank12");
//        bank1.setId("b0f4fe10-79aa-4c6f-9854-4fc8b119a58e");
//        bankService.save(bank1);
//        bankStrategyService.process(List.of(bank1, bank2, bank3));

//        bankRepository.delete(bank);

//        System.out.println(bank.getId() + " " + client.getId());
//        Set<Bank_Client> clientSet = bank.getClientBankRelationships();
//
//        Bank_Client bank_client = new Bank_Client();
//        bank_client.setBank(bank);
//        bank_client.setClient(client);
//        bank_client.setRating("988");
//
//        clientSet.add(bank_client);
//        bank.setClientBankRelationships(clientSet);

//        System.out.println(bank.getClientBankRelationships());


//        bankService.save(bank);
//        for (Bank_Client bk : bank.getClientBankRelationships()) {
//            bk.setRating("10");
//            System.out.println(bk.getBank().getId() + " " + bk.getClient().getId() + " " + bk.getRating());
//        }
//        updateBank(bank);
        bankService.save(bank);


    }

    public void updateBank(Bank bank) {
        for (Bank_Client bk : bank.getClientBankRelationships()) {
            bk.setRating("1000");
            System.out.println(bk.getBank().getId() + " " + bk.getClient().getId() + " " + bk.getRating());
        }
    }
}
