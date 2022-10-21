package com.example.web.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person_2")
@Data
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 4, message = "Имя должно быть больше 4 символов")
    @Column(name = "username")
    private String username;

    @Size(min = 8, message = "Имя должно быть больше или равно 8 символам")
    @Column(name = "password")
    private String password;

    @Min(value = 18, message = "Age should be greater than 18")
    @Column(name = "age")
    private int age;

    @NotEmpty
    @Email(message = "Incorrect gmail") // use 'reg ex' value
    @Column(name = "gmail")
    private String gmail;

    @Column(name = "role")
    private String role;

    public Person(){}
}
