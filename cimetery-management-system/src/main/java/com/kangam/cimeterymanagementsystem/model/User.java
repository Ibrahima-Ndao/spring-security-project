package com.kangam.cimeterymanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Transient
    private String token;
}
