package net.briandupreez.provider;

import java.util.List;

public class User {
    private String userName;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> groups;

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(final List<String> groups) {
        this.groups = groups;
    }
}
