package com.yllu.jpa.springmanytomanytest.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RelationshipKey implements Serializable {

    @Column(name = "client_id")
    String clientId;

    @Column(name = "bank_id")
    String bankId;



}
