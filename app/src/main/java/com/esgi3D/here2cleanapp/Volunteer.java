package com.esgi3D.here2cleanapp;

import java.util.Date;

public class Volunteer {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private boolean zoneManager;

    public Volunteer(int id, String firstName, String lastName, Date birthday, boolean zoneManager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.zoneManager = zoneManager;
    }

    public Volunteer() {
    }



}
