package no.ntnu.gr12.krrr_project.DBClasses.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value("${jwt_secret_key}")
    private String SECRET_KEY;
    /**
     * Key inside JWT token where roles are stored
     */
    private static final String JWT_AUTH_KEY = "roles";

    public String generateToken(UserDetails userDetails){
        final long TIME_NOW = System.currentTimeMillis();
        final long MILLISECONDS_IN_HOUR = 60*60*1000;
        final long TIME_AFTER_ONE_HOUR = TIME_NOW + MILLISECONDS_IN_HOUR;

        return Jwts.builder();
    }
}
