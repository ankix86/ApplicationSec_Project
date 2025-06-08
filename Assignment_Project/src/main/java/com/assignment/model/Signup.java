package com.assignment.model;

public class Signup {
    private String userName;
    private String userEmail;
    private String password;
    private String preferredName;
    private String name;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPreferredName() { return preferredName; }
    public void setPreferredName(String preferredName) { this.preferredName = preferredName; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
