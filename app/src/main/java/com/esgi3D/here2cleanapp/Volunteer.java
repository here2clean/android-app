package com.esgi3D.here2cleanapp;

import java.util.Date;

public class Volunteer {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String password;
    private String email;
    private String city;
    private String cityCode;
    private String address;


    public Volunteer(int id, String firstName, String lastName, Date birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Volunteer() {
    }

    public Volunteer(String email, String password, String firstName, String lastName){
        this.email =email;
        this.password = password;;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = new Date();

    }



}
