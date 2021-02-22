package com.example.demo.hibernate.proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "family")
    private List<Parent> children;

    public List<Parent> getChildren() {
        return children;
    }

    public void addChild(Parent child) {
        if (children==null) {
            children = new ArrayList<>();
        }
        children.add(child);
        child.setFamily(this);
    }
}
