package de.drue.UserApp.Repository;

import de.drue.UserApp.Entity.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRoleRepositoryTests {
    @Autowired
    private UserRoleRepository userRoleRepository;
    private UserRole role;

    @BeforeEach
    public void init() {
        role = UserRole.builder()
                .role("ROLE_USER")
                .build();
    }

    @Test
    public void userRoleRepositorySaveReturnsSavedUserRole(){
        // Arrange

        // Act
        UserRole savedUserRole = userRoleRepository.save(role);

        // Assert
        Assertions.assertThat(savedUserRole).isNotNull();
        Assertions.assertThat(savedUserRole.getId()).isGreaterThan(0);
        Assertions.assertThat(savedUserRole).isEqualTo(role);
    }

    @Test
    public void userRoleRepositoryFindByIdReturnsSavedUserRole(){
        // Arrange

        // Act
        userRoleRepository.save(role);

        UserRole savedUserRole = userRoleRepository.findById(role.getId()).get();

        // Assert
        Assertions.assertThat(savedUserRole).isNotNull();
        Assertions.assertThat(savedUserRole.getId()).isGreaterThan(0);
        Assertions.assertThat(savedUserRole).isEqualTo(role);
    }
}
