package com.uks.ronak.core.day9;

import java.io.Serializable;

public class EmpInfo extends Thread implements Serializable {
    public int userId;
    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public String userRole;
    public String address;
    public String city;
    public long mobileNumber;
    public long basicSalary;

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    // this constructor for userLogInInfoFile
    public EmpInfo(int userId, String userName, String password, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }
// this constructor for userInfoFile
    public EmpInfo(int userId, String firstName, String lastName, String address, String city, long basicSalary, long mobileNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.basicSalary = basicSalary;
        this.mobileNumber = mobileNumber;
    }
    public EmpInfo(int userId, String firstName, String lastName, String address, String city, long basicSalary, long mobileNumber,String userRole) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.basicSalary = basicSalary;
        this.mobileNumber = mobileNumber;
        this.userRole=userRole;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public long getBasicSalary() {
        return basicSalary;
    }
}
