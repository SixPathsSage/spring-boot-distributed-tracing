package com.service.remote.controller;

import com.service.remote.entity.Account;
import com.service.remote.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class AccountController {
    Logger logger = Logger.getLogger(AccountController.class.getName());

    @Autowired
    public AccountRepository accountRepository;

    @GetMapping("/account/{id}")
    public ResponseEntity<String> getAccount(@PathVariable("id") Long id) {
        logger.info("Remote API Called " + id);
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) {
            logger.info("Account not found for id " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            logger.info("Account found for id " + id);
            return new ResponseEntity<>(account.get().getHolderName(), HttpStatus.OK);
        }
    }
}
