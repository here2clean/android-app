package com.esgi3D.here2cleanapp;

public class Constants {
    public static final  int RC_SIGN_IN = 1000;
    private final static String REMOTE_API_URL = "http://heretoclean.cambar.re";
    private final static String ASSOC_API = "/api/association";
    private final static String EVENT_API = "/api/event";
    private final static String VOLUNTEER_API = "/api/volunteer";
    public final static  String SHOP_URL = "http://www.google.fr";

    public static final String API_ADD_VOLUNTEER_EVENT = REMOTE_API_URL+EVENT_API+"/addVolunteer" ;
    public static final String API_REMOVE_VOLUNTEER_EVENT = REMOTE_API_URL+EVENT_API+"/removeVolunteer";
    public static final String API_GET_VOLUNTEER_BY_MAIL = REMOTE_API_URL+VOLUNTEER_API+"/findByEmail" ;

    public final static String API_GET_ALL_ASSOC = REMOTE_API_URL+ASSOC_API+"/all";
    public static final String API_GET_ALL_EVENT = REMOTE_API_URL+EVENT_API+"/all";

    public static final String API_VOLUNTEER_SIGNUP = REMOTE_API_URL+VOLUNTEER_API+"/signUp";

}
