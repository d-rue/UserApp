package de.drue.UserApp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Home", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public ResponseEntity<String> user(){
        return new ResponseEntity<>("Hallo User", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return new ResponseEntity<>("Hallo Admin", HttpStatus.OK);
    }
}
