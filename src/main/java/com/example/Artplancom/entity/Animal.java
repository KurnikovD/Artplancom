package com.example.Artplancom.entity;

import com.fasterxml.jackson.databind.DatabindException;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(min = 4, message = "Не менее 4 символов")
    @Column(name = "nick_name", nullable = false, unique = true)
    private String nickName;
    private String sex;
    private Date birthday;

    @OneToMany
    private AnimalType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal(){}

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
