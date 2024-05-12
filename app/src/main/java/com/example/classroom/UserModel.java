package com.example.classroom;

public class UserModel {

    String name, email, image;

    public UserModel() {
    }

    public UserModel(String name, String email, String image) {
        this.name = name;
        this.email = email;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Image: " + image;
    }
}
