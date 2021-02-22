package com.example.demo.spring.proxy;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class SampleProxiedClass {

    @Transactional
    public void doThis() {
        doThat();
        doThatAsync();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doThat() {

    }

    @Async
    public void doThatAsync() {

    }
}
