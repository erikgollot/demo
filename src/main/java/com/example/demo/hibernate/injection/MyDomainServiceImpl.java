package com.example.demo.hibernate.injection;

import org.springframework.stereotype.Component;

@Component
public class MyDomainServiceImpl implements MyDomainService {
    @Override
    public Double computeAverageAge() {
        Double average = 10.0d;
        // Do real calculation
        return average;
    }
}
