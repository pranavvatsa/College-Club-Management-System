package com.example.application.ooad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clubs")
public class Club {

    @Id
    private String id;
    private String name;
    // Add more fields as needed

    // Constructors
    public Club() {
    }

    public Club(String name) {
        this.name = name;
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

    // toString() method (optional)
    @Override
    public String toString() {
        return "Club{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
