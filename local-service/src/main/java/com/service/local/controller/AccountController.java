package com.service.local.controller;

import com.service.local.entity.Account;
import com.service.local.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class AccountController {

    Logger logger = Logger.getLogger(AccountController.class.getName());

    @Autowired
    private AccountRepository accountRepository;

    @Value("${service.host}")
    private String serviceHost;

    @Value("${service.port}")
    private String servicePort;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/account-info/{id}")
    public ResponseEntity<Account> getAccountInfo(@PathVariable("id") Long id) {
        try {
            String url = "http://" + serviceHost + ":" + servicePort + "/account/"+ id;
            logger.info("Local API Called " + id);
            String accountName = restTemplate.getForObject(url, String.class);
            logger.info("Received Account Name " + accountName + " for Id " + id);
            Account account = accountRepository.save(new Account(id, accountName));
            logger.info("Saved Account info " + account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception exception) {
            logger.severe("Unable to find account for id " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}