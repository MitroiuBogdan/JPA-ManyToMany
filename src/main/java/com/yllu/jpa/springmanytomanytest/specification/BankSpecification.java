package com.yllu.jpa.springmanytomanytest.specification;

import com.yllu.jpa.springmanytomanytest.model.Bank;
import com.yllu.jpa.springmanytomanytest.model.Bank_;
import com.yllu.jpa.springmanytomanytest.model.Bank_Client_;
import com.yllu.jpa.springmanytomanytest.model.Client_;
import org.springframework.data.jpa.domain.Specification;


public class BankSpecification {

    public static Specification<Bank> getByName(String name) {
        if (name == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Bank_.NAME), name);
    }

    public static Specification<Bank> getByClientId(String clientId) {
        if (clientId == null) {
            return null;
        }
        return (root, query, criteriaBuilder) ->
                (root.join(Bank_.clientBankRelationships).join(Bank_Client_.client).get(Client_.id)).in(clientId);
    }

    public static Specification<Bank> getByClientIdAndName(String clientId, String name) {
        return getByClientId(clientId).and(getByName(name));

    }

}
