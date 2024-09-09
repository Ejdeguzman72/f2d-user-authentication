package com.f2d.user_authentication.domain;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "users")
public class F2DUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;
    private String firstname;
    private String lastname;
    private LocalDate creationDate;
    private LocalDate lastUpdatetime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return user authorities here
        return null; // Update according to your needs
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement according to your needs
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement according to your needs
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement according to your needs
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement according to your needs
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(LocalDate lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }
}