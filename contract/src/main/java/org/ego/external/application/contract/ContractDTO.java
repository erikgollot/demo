package org.ego.external.application.contract;

import org.ego.external.application.person.PersonDTO;

public class ContractDTO {
    private Long id;

    private String num;

    private PersonDTO owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public PersonDTO getOwner() {
        return owner;
    }

    public void setOwner(PersonDTO owner) {
        this.owner = owner;
    }
}
