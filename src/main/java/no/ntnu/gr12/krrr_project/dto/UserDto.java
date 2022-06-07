package no.ntnu.gr12.krrr_project.dto;

public class UserDto {

    private String username;
    private String id;

    public UserDto(String username, String id){
        this.username = username;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
