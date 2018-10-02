package com.example.sergey_katsapov.finally_project.model;



public class Sport {

    private String name;
    private String description;
    private String image_url;


    public Sport() {
    }

    public Sport(String name, String description, String image_url) {
        this.name = name;
        this.description = description;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
