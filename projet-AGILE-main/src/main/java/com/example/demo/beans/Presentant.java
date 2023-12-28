package com.example.demo.beans;

import javax.persistence.*;

@Entity
public class Presentant {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String firstname;
        private String lastname;
        private String email;
        private String researchStructure;
        private String university;
        private String status;
        private String thesisYear;
        private String title;
        @Lob
        private byte[] pdfFile;
        public Presentant() {
            // Constructeur par défaut nécessaire pour JPA
        }

    public Presentant(String firstname, String lastname, String email, String researchStructure,
                      String university, String status, String thesisYear, String title, byte[] pdfFile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.researchStructure = researchStructure;
        this.university = university;
        this.status = status;
        this.thesisYear = thesisYear;
        this.title = title;
        this.pdfFile = pdfFile;
    }

        // Getters et Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        // Ajoutez des getters et setters pour les autres champs

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

        public String getThesisYear() {
            return thesisYear;
        }

        public void setThesisYear(String thesisYear) {
            this.thesisYear = thesisYear;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public byte[] getPdfFile() {
            return pdfFile;
        }

        public void setPdfFile(byte[] pdfFile) {
            this.pdfFile = pdfFile;
        }
    }
