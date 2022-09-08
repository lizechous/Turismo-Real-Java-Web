package com.duoc.turismo.gateway.model;

import java.util.Date;

public class Activity{
    public String name;
    public int code;
    public String category;
    public boolean subject_to_vat;
    public Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSubject_to_vat() {
        return subject_to_vat;
    }

    public void setSubject_to_vat(boolean subject_to_vat) {
        this.subject_to_vat = subject_to_vat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
