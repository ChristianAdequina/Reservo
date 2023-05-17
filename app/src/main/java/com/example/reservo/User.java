package com.example.reservo;

public class User {
    private String fName;
    private String lName;
    private String phoneNo;
    private String email;

    public User(String fName, String lName, String phoneNo, String email) {
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
