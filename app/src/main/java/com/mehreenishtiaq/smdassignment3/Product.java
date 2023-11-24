package com.mehreenishtiaq.smdassignment3;

public class Product {

    String name, hourlyRate, description, city;

    public Product() {
    }

    public Product(String name, String hourlyRate, String description, String city) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.description = description;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
