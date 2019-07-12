package com.esgi3D.here2cleanapp;


import java.io.Serializable;

public class Event implements Serializable {
    private int id;
    private String desc;
    private String name;
    private String location;
    private String image;
    private int association;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAssociation() {
        return association;
    }

    public void setAssociation(int association) {
        this.association = association;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", desc='" + desc + '\'' + ", name='" + name + '\'' + ", location='" + location + '\'' + ", image='" + image + '\'' + ", association=" + association + '}';
    }
}
