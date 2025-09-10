package com.hackathon.authtech.domain.entity;

import com.hackathon.authtech.domain.Enums.Authority;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "passwords")
@Entity
public class Passwords {

    @Id
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false , unique = true)
    private String mail;

    @UniqueElements
    private Integer grNo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;
}
