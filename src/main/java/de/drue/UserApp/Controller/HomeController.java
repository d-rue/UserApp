package de.drue.UserApp.Controller;

import de.drue.UserApp.Model.UserPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    UserPrincipal userName = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String user(){ return "Hallo " + userName.getUsername(); }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){ return "Hallo " + userName.getUsername(); }
}
