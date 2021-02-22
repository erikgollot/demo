package org.ego.person.domain.dao.person;

import org.ego.person.domain.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person,Long> {
}
