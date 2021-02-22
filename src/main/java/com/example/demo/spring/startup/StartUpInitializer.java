package com.example.demo.spring.startup;

import com.example.demo.hibernate.injection.MyDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartUpInitializer {
    @Autowired
    private MyDomainService service;

    @PostConstruct
    public void init() {
        service.computeAverageAge();
    }
}
