package com.example.Artplancom.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;


@Entity
@Table(name = "User")
public class User implements UserDetails {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 4, message = "Не менее 4 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 4, message = "Не менее 4 символов")
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private String passwordConfirm;

    @OneToMany
    private Set<Animal> animalList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(Set<Animal> animalList) {
        this.animalList = animalList;
    }
}
