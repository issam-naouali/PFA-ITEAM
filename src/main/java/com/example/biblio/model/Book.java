package com.example.biblio.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name="book")
public class Book implements Serializable {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto Increament
    private Long id;

    private String title;
    private String edition;

    // default constructor
    public Book() { super();
    }

    // parametrized Constructor
    public Book( Long id, String title, String edition) {
        this.id = id;
        this.title = title;
        this.edition = edition;
    }

    // Getters and Setters for the attributes

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
