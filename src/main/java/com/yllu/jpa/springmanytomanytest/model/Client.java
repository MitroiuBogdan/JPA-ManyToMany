package com.yllu.jpa.springmanytomanytest.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "YLLU_CLIENT")
public class Client implements Serializable {

    @Id
    String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Client() {
    }

    @OneToMany(mappedBy = "client")
    private Set<Bank_Client> clientBankRelationships = new HashSet<>();

    public Client(String id, String name) {
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

    public void setName(String name) {
        this.name = name;
    }
}
