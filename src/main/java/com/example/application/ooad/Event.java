package com.example.application.ooad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {

    @Id
    private String id;
    private String name;
    private String clubInCharge;
    private String date;
    private double registrationFees;


    public Event(String name, String clubInCharge, String date, double registrationFees) {
        this.name = name;
        this.clubInCharge = clubInCharge;
        this.date = date;
        this.registrationFees = registrationFees;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubInCharge() {
        return clubInCharge;
    }

    public void setClubInCharge(String clubInCharge) {
        this.clubInCharge = clubInCharge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRegistrationFees() {
        return registrationFees;
    }

    public void setRegistrationFees(double registrationFees) {
        this.registrationFees = registrationFees;
    }
}
