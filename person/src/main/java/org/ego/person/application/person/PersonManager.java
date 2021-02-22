package org.ego.person.application.person;

import org.ego.person.application.address.AddressDTO;

import java.util.List;

public interface PersonManager {
    PersonDTO getPerson(Long id);
    AddressDTO mainAddressOf(Long personId);

    List<PersonDTO> findAllPersons(boolean justOld);
}
