package com.example.demo.hibernate.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class FamilyInitializer {
    @Autowired
    private FamilyDAO familyDAO;

    @Transactional
    public void init() {
        Optional<Family> theFamilyOpt = familyDAO.findById(1L);
        if (!theFamilyOpt.isPresent()) {
            Family theFamily = new Family();
            Child1 child1 = new Child1();
            child1.setProp1("prop1 value");
            Child2 child2 = new Child2();
            child2.setProp2("prop2 value");
            theFamily.addChild(child1);
            theFamily.addChild(child2);
            familyDAO.save(theFamily);
        }
    }
}
