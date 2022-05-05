package no.ntnu.gr12.krrr_project.DBClasses.dto;

public class SignupDto {
    private final String username;
    private final String password;

    public SignupDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
