package com.example.demo.hibernate.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Component
public class MyEntity {
    @Id
    private Long id;
    private String name;
    private Date birthDate;

    public boolean amIOlderThanAverage() {
        return service.computeAverageAge() < computeAge() ? true : false;
    }

    private Double computeAge() {
        // Do real calculation
        return 25.0d;
    }

    private static MyDomainService service;
    @Autowired
    public static void setService(MyDomainService service) {
        MyEntity.service = service;
    }

}
