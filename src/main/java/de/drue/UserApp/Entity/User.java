package de.drue.UserApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, insertable = false)
    private long id;
    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String userName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,
                cascade = CascadeType.MERGE)
    @JoinTable(name = "JOIN_USERS_ROLES",
                joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
    private List<UserRole> roles = new ArrayList<>();
    @Column(name = "IS_ACCOUNT_NON_EXPIRED")
    private boolean isAccountNonExpired;
    @Column(name = "IS_ACCOUNT_NON_LOCKED")
    private boolean isAccountNonLocked;
    @Column(name = "IS_CREDENTIALS_NON_EXPIRED")
    private boolean isCredentialsNonExpired;
    @Column(name = "IS_ENABLED")
    private boolean isEnabled;

}

