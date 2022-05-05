package no.ntnu.gr12.krrr_project.DBClasses.controllers;

import no.ntnu.gr12.krrr_project.DBClasses.models.User;
import no.ntnu.gr12.krrr_project.DBClasses.security.AuthenticationRequest;
import no.ntnu.gr12.krrr_project.DBClasses.security.AuthenticationResponse;
import no.ntnu.gr12.krrr_project.DBClasses.security.JwtUtil;
import no.ntnu.gr12.krrr_project.DBClasses.security.UserInfoResponse;
import no.ntnu.gr12.krrr_project.DBClasses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Value("${cookie}")
    private String COOKIE;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            ));
        }catch (BadCredentialsException e){
            return new ResponseEntity<>("Invalid username or password" + e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            ));
        }catch (BadCredentialsException e){
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        ResponseCookie jwtCookie = ResponseCookie.from(COOKIE,jwt).build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getUsername()));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthenticationRequest authenticationRequest){
        String name = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        if(name != null && password != null){
            return new ResponseEntity<>(userService.addUser(new User(name,password)),HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid arguments",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signOut(){
        ResponseCookie cookie = jwtUtil.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("You have been signed out");
    }

}
