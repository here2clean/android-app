package com.esgi3D.here2cleanapp;

public class AssociationBuilder {
    private String name;
    private long rna;
    private String email;
    private long id;
    private String password;
    private String description;


    private AssociationBuilder(){

    };

    public AssociationBuilder(long id) {
        this.id = id;
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

    public Association build(){
        return new Association(this);
    }

    public  AssociationBuilder Named(String name){
        this.name = name;
        return  this;
    }

    public  AssociationBuilder WithRNA(Long RNA){
        this.rna = RNA;
        return  this;
    }
    public  AssociationBuilder WithDescription(String description){
        this.description = description;
        return  this;
    }
    public  AssociationBuilder WithPassword(String password){
        this.password  = password;
        return  this;
    }
    public  AssociationBuilder WithEmail(String email){
        this.email  = email;
        return  this;
    }

}
