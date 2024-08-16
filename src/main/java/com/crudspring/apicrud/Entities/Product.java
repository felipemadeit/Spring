package com.crudspring.apicrud.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    // PK for the DB
    @Id
    // Auto Increment generation
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    //Attributes
    private Long id;
    private String name;
    private double price;

    // Getter and setters of attributes
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    


    
}
