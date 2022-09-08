package com.duoc.turismo.gateway.model;

import java.util.ArrayList;

public class Data{
    public ArrayList<Activity> activities;
    public String name;
    public String rut;

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
