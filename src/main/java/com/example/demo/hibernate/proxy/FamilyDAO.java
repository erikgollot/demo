package com.example.demo.hibernate.proxy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyDAO extends JpaRepository<Family,Long> {
}
