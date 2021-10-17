package com.yllu.jpa.springmanytomanytest.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "YLLU_BANK")
public class Bank {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false)
    String id;

    @Column(name = "NAME", nullable = false)
    String name;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bank", cascade = CascadeType.ALL)
    Set<Bank_Client> clientBankRelationships = new HashSet<>();

    public Bank() {
    }

    public Bank(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Bank_Client> getClientBankRelationships() {
        return clientBankRelationships;
    }

    public void setClientBankRelationships(Set<Bank_Client> clientBankRelationships) {
        this.clientBankRelationships = clientBankRelationships;
    }

    public void setName(String name) {
        this.name = name;
    }

}
