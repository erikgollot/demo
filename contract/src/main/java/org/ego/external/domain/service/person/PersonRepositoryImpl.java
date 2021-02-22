package org.ego.external.domain.service.person;

import org.ego.external.domain.model.person.Person;
import org.ego.external.infrastructure.external.person.AddressEXT;
import org.ego.external.infrastructure.external.person.PersonEXT;
import org.ego.external.infrastructure.external.person.PersonExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonRepositoryImpl implements PersonRepository{
    @Autowired
    private PersonExternalService personExternalService;

    @Override
    public void getPerson(Person person) {
        PersonEXT personEXT = personExternalService.findPersonById(person.getExternalId());
        if (personEXT!=null) {
            person.setFirstName(personEXT.getPrenom());
            person.setLastName(personEXT.getNom());
            AddressEXT addressEXT = personExternalService.findMainAddressOf(person.getExternalId());
            if (addressEXT!=null) {
                person.setTown(addressEXT.getTown());
            }
        }
    }
}
