package com.example.casemodun6_be.model.DTO;

import com.example.casemodun6_be.model.Roles;

import java.util.List;

public class UserToken {
    private String userName;
    private String token;
    private List<Roles> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public UserToken() {
    }

    public UserToken(String userName, String token, List<Roles> roles) {
        this.userName = userName;
        this.token = token;
        this.roles = roles;
    }
}
