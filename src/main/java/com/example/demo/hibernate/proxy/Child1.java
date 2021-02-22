package com.example.demo.hibernate.proxy;

import javax.persistence.Entity;

@Entity
public class Child1 extends Parent {
    private String prop1;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }
}
