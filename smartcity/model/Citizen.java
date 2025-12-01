package com.smartcity.model;


public class Citizen extends User {
private String fullName;


public Citizen(String username, String password, String fullName) {
super(username, password);
this.fullName = fullName;
}


public String getFullName() { return fullName; }
}