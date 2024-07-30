package com.example.moviebooking;

import com.fasterxml.jackson.annotation.JsonProperty;

// Show class creates a user object
public class User {

    // Parameters
    @JsonProperty("username")
    private String username; // username
    @JsonProperty("credit-card-name")
    private String cCName; // credit card holder
    @JsonProperty("credit-card-ID")
    private int cCID; // credit card id
    @JsonProperty("cvv")
    private int cvv; // cvv
    @JsonProperty("age")
    private int age; // age of user
    @JsonProperty("seat-number")
    private String seatNumber; // seat numbers

    // Parameterized constructor
    public User(String username, String cCName, int cCID, int cvv, int age, String seatNumber) {
        this.username = username;
        this.cCName = cCName;
        this.cCID = cCID;
        this.cvv = cvv;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    // Default constructor
    public User() {
        this.username = "";
        this.cCName = "";
        this.cCID = 0;
        this.cvv = 0;
        this.age = 0;
        this.seatNumber = "";
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getcCName(String cCName) {
        return this.cCName;
    }

    public int getcCID() {
        return cCID;
    }

    public int getCvv() {
        return cvv;
    }

    public int getAge() {
        return age;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setcCName(String cCName) {
        this.cCName = cCName;
    }

    public void setcCID(int cCID) {
        this.cCID = cCID;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

}