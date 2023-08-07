package com.gamelibrary.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "idade",nullable = false)
    private int age;
    @Column(name = "saldo",nullable = false)
    private Double balance;
    @Column(name = "jogos",nullable = false)
    private int games;

}
