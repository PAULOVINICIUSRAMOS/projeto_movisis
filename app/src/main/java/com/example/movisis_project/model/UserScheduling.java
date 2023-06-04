package com.example.movisis_project.model;

import java.util.Date;

public class UserScheduling {

    private String name;
    private String box;
    private Date hour;
    private String modelCar;
    private String detailCar;
    private String attendantName;
    private String serviceDescription;

    public UserScheduling(String name, Date hour, String modelCar, String detailCar, String attendantName, String serviceDescription) {
        this.name = name;
        this.hour = hour;
        this.modelCar = modelCar;
        this.detailCar = detailCar;
        this.serviceDescription = serviceDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getDetailCar() {
        return detailCar;
    }

    public void setDetailCar(String detailCar) {
        this.detailCar = detailCar;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
