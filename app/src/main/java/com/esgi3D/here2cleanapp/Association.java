package com.esgi3D.here2cleanapp;

import java.io.Serializable;

public class Association implements Serializable {
    private String name;
    private long rna;
    private String email;
    private long id;
    private String password;
    private String description;
    private String urlImage;


    private Association() {
    }

    public Association(AssociationBuilder builder) {
        this.name = builder.getName();
        this.rna = builder.getRna();
        this.email = builder.getEmail();
        this.password = builder.getPassword();
        this.description = builder.getDescription();
        this.id  = builder.getId();
    }

    public String getName() {
        return name;
    }

    public long getRna() {
        return rna;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Association{" + "name='" + name + '\'' + ", rna=" + rna + ", email='" + email + '\'' + ", id=" + id + ", password='" + password + '\'' + ", description='" + description + '\'' + '}';
    }
}


