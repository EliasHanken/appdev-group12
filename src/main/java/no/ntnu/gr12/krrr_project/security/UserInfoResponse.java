package no.ntnu.gr12.krrr_project.security;

import java.io.Serializable;

public class UserInfoResponse implements Serializable {

    private String username;

    public UserInfoResponse(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
