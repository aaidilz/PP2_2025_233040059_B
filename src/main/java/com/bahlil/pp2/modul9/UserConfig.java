package com.bahlil.pp2.modul9;

import java.io.Serializable;

public class UserConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String username;
    private int fontSize;

    public UserConfig() {}

    public UserConfig(String username, int fontSize) {
        this.username = username;
        this.fontSize = fontSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    
    @Override
    public String toString() {
        return "UserConfig [Username=" + username + ", FontSize=" + fontSize + "]";
    }
}