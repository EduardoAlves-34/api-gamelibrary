package com.gamelibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "genero_jogos")
public class GenderGameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jogo_id")
    private GameModel game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genero_id")
    private GenderModel gender;

}
