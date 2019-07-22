package com.esgi3D.here2cleanapp;


import java.io.Serializable;

public class Event implements Serializable {
    private int id;
    private String description;
    private String name;
    private String location;
    private String urlImage;
    private int association;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAssociation() {
        return association;
    }

    public void setAssociation(int association) {
        this.association = association;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlIimage) {
        this.urlImage = urlIimage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", desc='" + description + '\'' + ", name='" + name + '\'' + ", location='" + location + '\'' + ", image='" + urlImage + '\'' + ", association=" + association + '}';
    }
}
