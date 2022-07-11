package com.example.Artplancom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 4, message = "Не менее 4 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 4, message = "Не менее 4 символов")
    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Transient
    @JsonIgnore
    private String passwordConfirm;

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

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return name;
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

}
