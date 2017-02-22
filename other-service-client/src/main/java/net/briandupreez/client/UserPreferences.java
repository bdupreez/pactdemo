package net.briandupreez.client;

import java.util.List;

public class UserPreferences {
    private String userName;
    private String userId;
    private List<String> preferences;

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

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(final List<String> preferences) {
        this.preferences = preferences;
    }
}
