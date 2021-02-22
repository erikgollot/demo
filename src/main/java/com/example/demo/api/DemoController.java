package com.example.demo.api;

import com.example.demo.hibernate.proxy.Family;
import com.example.demo.hibernate.proxy.FamilyDAO;
import com.example.demo.hibernate.proxy.Parent;
import com.example.demo.hibernate.proxy.ParentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private FamilyDAO familyDAO;

    @Autowired
    private ParentDAO parentDAO;

    @GetMapping(value = "/api/doThis")
    public void doThis() {
        Family family = familyDAO.getOne(1L);
        if (family instanceof Family) {
            System.out.println("Not a proxy");
        } else {
            System.out.println("This is a proxy");
        }
    }

    @GetMapping(value = "/api/doThat")
    public void doThat() {
        List<Parent> parents = parentDAO.findAll();
        parents.forEach(c->{

        });
    }
}
