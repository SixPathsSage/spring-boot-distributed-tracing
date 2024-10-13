package com.service.remote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}