package com.gamelibrary.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "usuario")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome",length = 50,nullable = false)
    private String name;
    @Column(name = "nick",length = 15,nullable = false)
    private String nick;
    @Column(name = "pais",length = 20,nullable = false)
    private String country;
    @Column(name = "data_nascimento",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birth;
    @Column(name = "saldo")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double balance;
    @Column(name = "jogos")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int games;
    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime creationDate;

}
