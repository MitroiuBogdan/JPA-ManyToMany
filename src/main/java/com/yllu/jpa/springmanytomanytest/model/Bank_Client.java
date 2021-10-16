package com.yllu.jpa.springmanytomanytest.model;

import javax.persistence.*;

@Entity
@Table(name = "YLLU_BANK_CLIENT")
public class Bank_Client {

    @Id
    String id;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    Bank bank;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @Column(name = "RATEING")
    String rating;

    public Bank_Client(Bank bank, Client client, String rating) {
        this.bank = bank;
        this.client = client;
        this.rating = rating;
    }

    public Bank_Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bank_Client(Bank bank, Client client) {
        this.bank = bank;
        this.client = client;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
