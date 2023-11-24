package com.mehreenishtiaq.smdassignment3;

public class User {

    String userId, name, email, phone, password, country, city;

    public User() {
    }

    public User(String id, String name, String email, String phone, String password, String country, String city) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.country = country;
        this.city = city;
    }

    public String getId() {
        return userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
