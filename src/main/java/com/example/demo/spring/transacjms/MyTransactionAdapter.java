package com.example.demo.spring.transacjms;

import org.springframework.core.Ordered;
import org.springframework.transaction.support.TransactionSynchronization;

public class MyTransactionAdapter implements TransactionSynchronization, Ordered {
    @Override
    public int getOrder() {
        return 2147483647;
    }

    @Override
    public void suspend() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void beforeCommit(boolean readOnly) {

    }

    @Override
    public void beforeCompletion() {

    }

    @Override
    public void afterCommit() {

    }

    @Override
    public void afterCompletion(int status) {

    }
}
