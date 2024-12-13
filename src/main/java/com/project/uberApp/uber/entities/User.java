package com.project.uberApp.uber.entities;

import com.project.uberApp.uber.entities.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.Set;

@Entity
@Data
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


}
