package com.intensive.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    public UserEntity(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
