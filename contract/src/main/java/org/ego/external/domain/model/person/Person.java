package org.ego.external.domain.model.person;

import org.ego.external.domain.service.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Id from Person Repository
    private Long externalId;

    @Transient
    private String firstName;
    @Transient
    private String lastName;
    @Transient
    private String town;

    public Long getId() {
        return id;
    }

    public Long getExternalId() {
        return externalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTown() {
        return town;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTown(String town) {
        this.town = town;
    }

    private static PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        Person.personRepository = personRepository;
    }

    @PostLoad
    public void postLoad() {
        personRepository.getPerson(this);
    }
}
