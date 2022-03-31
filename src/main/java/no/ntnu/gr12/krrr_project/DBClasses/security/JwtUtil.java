package no.ntnu.gr12.krrr_project.DBClasses.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
    @Value("${jwt_secret_key}")
    private String SECRET_KEY;
    /**
     * Key inside JWT token where roles are stored
     */
    private static final String JWT_AUTH_KEY = "roles";


    /**
     * @param userDetails Object containing user details.
     * @return JWT token string
     */
    public String generateToken(UserDetails userDetails){
        final long TIME_NOW = System.currentTimeMillis();
        final long MILLISECONDS_IN_HOUR = 60*60*1000;
        final long TIME_AFTER_ONE_HOUR = TIME_NOW + MILLISECONDS_IN_HOUR;

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim(JWT_AUTH_KEY, userDetails.getAuthorities())
                .setIssuedAt(new Date(TIME_NOW))
                .setExpiration(new Date(TIME_AFTER_ONE_HOUR))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }

    /**
     * Find username from JWT token
     *
     * @param token JWT token
     * @return Username
     */
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
