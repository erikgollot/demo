package org.ego.person.domain.model.person;

import org.ego.person.domain.model.address.Address;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;

import javax.persistence.*;

@Entity
@FilterDef(name="justOld")
@Filters({
        @Filter(name="justOld", condition = "old=1")
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(50)")
    private String nom;
    @Column(columnDefinition = "VARCHAR(50)")
    private String prenom;

    @OneToOne
    private Address mainAddress;

    // Donnée sans grande signification pour illustrer les Filters
    private Boolean old;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Address getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Boolean getOld() {
        return old;
    }

    public void setOld(Boolean old) {
        this.old = old;
    }
}
