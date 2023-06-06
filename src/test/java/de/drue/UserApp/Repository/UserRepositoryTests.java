package de.drue.UserApp.Repository;

import com.github.javafaker.Faker;
import de.drue.UserApp.Entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Locale;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    private Faker faker = new Faker(Locale.GERMAN);
    private User user;

    @BeforeEach
    public void init() {
        user = User.builder()
                .userName("user")
                .password("user")
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();
    }

    @Test
    public void UserRepository_Save_ReturnsSavedUser(){
        // Arrange

        // Act
        User savedUser = userRepository.save(user);

        // Assert
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
        Assertions.assertThat(savedUser).isEqualTo(user);
    }

    @Test
    public void UserRepository_FindById_ReturnsSavedUser(){
        // Arrange

        // Act
        userRepository.save(user);

        User savedUser = userRepository.findById(user.getId()).get();

        // Assert
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
        Assertions.assertThat(savedUser).isEqualTo(user);
    }

    @Test
    public void UserRepository_FindByUserName_ReturnsSavedUser(){
        // Arrange

        // Act
        userRepository.save(user);

        User savedUser = userRepository.findByUserName(user.getUserName()).get();

        // Assert
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
        Assertions.assertThat(savedUser).isEqualTo(user);
    }
}
