package com.example.demo.hibernate.proxy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentDAO extends JpaRepository<Parent,Long> {
}
