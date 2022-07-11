package com.example.Artplancom.entity;

import java.sql.Date;

public class AnimalJson {
    private Long id;
    private String nickName;
    private String sex;
    private Date birthday;
    private UserJson user;
    private String animalType;

    public AnimalJson(Long id, String nickName, String sex, Date birthday, UserJson user, String animalType) {
        this.id = id;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
        this.user = user;
        this.animalType = animalType;
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

    public UserJson getUser() {
        return user;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
