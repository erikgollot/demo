package com.example.demo.hibernate.proxy;

import javax.persistence.Entity;

@Entity
public class Child2 extends Parent {
    private String prop2;

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }
}
