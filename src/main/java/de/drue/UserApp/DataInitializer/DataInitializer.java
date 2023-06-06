package de.drue.UserApp.DataInitializer;

import de.drue.UserApp.Entity.User;
import de.drue.UserApp.Entity.UserRole;
import de.drue.UserApp.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public final class DataInitializer implements ApplicationRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public DataInitializer(final PasswordEncoder passwordEncoder, final UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public void run(final ApplicationArguments args) {
        User user = User.builder()
                .userName("user")
                .password(passwordEncoder.encode("user"))
                .roles(List.of(UserRole.builder().role("USER").build()))
                .build();

        User admin = User.builder()
                .userName("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(List.of(UserRole.builder().role("ADMIN").build(), UserRole.builder().role("USER").build()))
                .build();

        userRepository.saveAll(List.of(user, admin));

        log.info("Initialized db data for user and admin");
    }
}
