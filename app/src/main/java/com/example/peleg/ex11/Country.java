package com.example.peleg.ex11;

/**
 * Created by peleg on 5/11/2018.
 */

public class Country {
    String name;
    String flag;
    String details;
    String anthem;
    String shorty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAnthem() {
        return anthem;
    }

    public void setAnthem(String anthem) {
        this.anthem = anthem;
    }

    public String getShorty() {
        return shorty;
    }

    public void setShorty(String shorty) {
        this.shorty = shorty;
    }

    @Override
    public String toString() {
        return name;
    }
}
