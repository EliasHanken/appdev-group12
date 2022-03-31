package no.ntnu.gr12.krrr_project.DBClasses.security;

/**
 * Data that we will send as a response to the user when the authentication is successful
 */
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
