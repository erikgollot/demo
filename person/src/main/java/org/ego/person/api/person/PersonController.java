package org.ego.person.api.person;

import org.ego.person.application.address.AddressDTO;
import org.ego.person.application.person.PersonDTO;
import org.ego.person.application.person.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonManager personManager;

    @RequestMapping(value = "/api/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findPersonById(@PathVariable Long id) {
        return personManager.getPerson(id);
    }

    @RequestMapping(value = "/api/person/{id}/mainAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressDTO findMainAddressOf(@PathVariable Long id) {
        return personManager.mainAddressOf(id);
    }

    @RequestMapping(value = "/api/person/all/{justOld}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAllPersons(@PathVariable boolean justOld) {
        return personManager.findAllPersons(justOld);
    }

}
