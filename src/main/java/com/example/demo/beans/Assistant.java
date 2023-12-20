package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
  public class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String researchStructure;
    private String university;
    private String status;

    // Constructeur par défaut sans arguments
    public Assistant() {
    }

    // Constructeur avec tous les champs sauf l'ID (géré automatiquement)
    public Assistant(String firstname, String lastname, String email, String researchStructure, String university, String status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.researchStructure = researchStructure;
        this.university = university;
        this.status = status;
    }



    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResearchStructure() {
        return researchStructure;
    }

    public void setResearchStructure(String researchStructure) {
        this.researchStructure = researchStructure;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
