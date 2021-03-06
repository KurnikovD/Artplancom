package com.example.Artplancom.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 4, message = "Не менее 4 символов")
    @Column(name = "nick_name", nullable = false, unique = true)
    private String nickName;
    private String sex;
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String animalType;

    public Animal() {
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
