package de.drue.UserApp.DataInitializer;

import de.drue.UserApp.Entity.User;
import de.drue.UserApp.Entity.UserRole;
import de.drue.UserApp.Repository.UserRepository;
import de.drue.UserApp.Repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public final class DataInitializer implements ApplicationRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public void run(final ApplicationArguments args) {
        UserRole roleUser = UserRole.builder()
                .role("ROLE_USER")
                .build();

        UserRole roleAdmin = UserRole.builder()
                .role("ROLE_ADMIN")
                .build();

        userRoleRepository.saveAll(List.of(roleUser, roleAdmin));

        User user = User.builder()
                .userName("user")
                .password(passwordEncoder.encode("user"))
                .roles(List.of(roleUser))
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();

        User admin = User.builder()
                .userName("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(List.of(roleUser, roleAdmin))
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();

        userRepository.saveAll(List.of(user, admin));

        log.info("Initialized db data for user and admin");
    }
}
