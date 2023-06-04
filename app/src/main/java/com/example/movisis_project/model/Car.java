package com.example.movisis_project.model;

public class Car {

    private String model;
    private String year;
    private Double price;
    private String urlImage;

    public Car(String model, String year, Double price, String urlImage) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.urlImage = urlImage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
