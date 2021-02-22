package org.ego.person.application.person;

import org.ego.person.application.address.AddressDTO;
import org.ego.person.application.mapper.OrikaBeanMapper;
import org.ego.person.domain.dao.person.PersonDAO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class PersonManagerImpl implements PersonManager{
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;


    @Override
    public PersonDTO getPerson(Long id) {
        return orikaBeanMapper.convertDTO(personDAO.getOne(id),PersonDTO.class);
    }

    @Override
    public AddressDTO mainAddressOf(Long personId) {
        return orikaBeanMapper.convertDTO(personDAO.getOne(personId).getMainAddress(),AddressDTO.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PersonDTO> findAllPersons(boolean justOld) {
        if (justOld) {
            getSession().enableFilter("justOld");
        }
        return orikaBeanMapper.convertListDTO(personDAO.findAll(),PersonDTO.class);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
