package com.example.demo.hibernate.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Configuration
public class FamilyConfiguration {

    @Autowired
    private FamilyInitializer initializer;

    @PostConstruct
    public void init() {
       initializer.init();
    }
}
