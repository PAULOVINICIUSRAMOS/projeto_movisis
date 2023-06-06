package com.example.movisis_project.model;

public class Notification {

    private String date;
    private String tittle;
    private String description;

    public Notification(String date, String tittle, String description) {
        this.date = date;
        this.tittle = tittle;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
