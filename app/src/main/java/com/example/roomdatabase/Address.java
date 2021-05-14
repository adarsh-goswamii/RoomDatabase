package com.example.roomdatabase;

public class Address {
    private String city;
    private int zipCode;
    private String State;

    public Address(String city, int zipCode, String State) {
        this.city = city;
        this.zipCode = zipCode;
        this.State = State;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
