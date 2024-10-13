package com.service.local.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    private Long id;

    private String holderName;

    public Account() {
    }

    public Account(Long id, String holderName) {
        this.id = id;
        this.holderName = holderName;
    }

    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public String getHolderName() {
        return holderName;
    }

    public Account setHolderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", holderName='").append(holderName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}