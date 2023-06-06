package com.example.movisis_project.model;

import java.util.Date;

public class User {

    private String fullname;
    private String socialname;
    private String document;
    private Date datebirth;
    private String country;
    private String state;
    private String city;
    private String email;
    private String mobilenumber;

    public User(String fullname, String socialname, String document, Date datebirth, String country, String state, String city, String email, String mobilenumber) {
        this.fullname = fullname;
        this.socialname = socialname;
        this.document = document;
        this.datebirth = datebirth;
        this.country = country;
        this.state = state;
        this.city = city;
        this.email = email;
        this.mobilenumber = mobilenumber;
    }

    public User() {

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSocialname() {
        return socialname;
    }

    public void setSocialname(String socialname) {
        this.socialname = socialname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(Date datebirth) {
        this.datebirth = datebirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
