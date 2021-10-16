package com.yllu.jpa.springmanytomanytest.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "YLLU_BANK_CLIENT")
public class Bank_Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false)
    String id;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    Bank bank;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
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
