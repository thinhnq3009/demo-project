package com.intern.demoproject.entity;

import com.intern.demoproject.utils.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static com.intern.demoproject.utils.Constants.User.DEFAULT_AVATAR;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String username;

    @Column(length = 50)
    private String fullname; // Can update

    @Column(length = 50)
    private String email; // Can update

    @Column(length = 250)
    private String avatar;

    @Column(length = 250)
    private String password;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Role role;


    @PrePersist
    protected void onCreate() {
        if (this.role == null)
            this.role = Role.USER;
        if (this.avatar == null || this.avatar.isEmpty())
            this.avatar = DEFAULT_AVATAR;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
