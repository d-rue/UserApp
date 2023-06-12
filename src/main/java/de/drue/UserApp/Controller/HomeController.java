package de.drue.UserApp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Home", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public ResponseEntity<String> user(@Nullable final Authentication authentication){
        String s;
        if (authentication == null){
            s = "Hallo";
        } else {
            s = "Hallo " + authentication.getName();
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> admin(@Nullable final Authentication authentication){
        String s;

        if (authentication == null){
            s = "Hallo";
        } else {
            s = "Hallo " + authentication.getName();
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
