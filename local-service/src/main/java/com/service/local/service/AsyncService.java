package com.service.local.service;

import com.service.local.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class AsyncService {

    @Autowired
    private Executor asyncExecutorPool;

    @Async("asyncExecutorPool")
    public void executeAsyncTask(Account account) {
        try {
            Thread.sleep(5000);
            System.out.println("Executed asynchronously: " + account + " | Thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task was interrupted");
        }
    }
}
