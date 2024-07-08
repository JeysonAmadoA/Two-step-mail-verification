package com.Triju.Users.Domain.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_day", columnDefinition = "DATE")
    private LocalDate birthDay;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "activation_token", nullable = false)
    private String activationToken;

    @Column(name = "verified_user")
    private boolean verifiedUser;

}
