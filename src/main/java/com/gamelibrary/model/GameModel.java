package com.gamelibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "jogo")
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome",length = 50,nullable = false)
    private String name;
    @Column(name = "valor",nullable = false)
    private Double value;
    @Column(name = "genero",length = 20,nullable = false)
    private String gender;
    @Column(name = "descricao",length = 100,nullable = false)
    private String description;
    @Column(name = "data",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;
    @Column(name = "tamanho_gb",nullable = false)
    private Double sizeGB;
    @Column(name = "distribuidora",length = 50,nullable = false)
    private String distributor;
    @Column(name = "classificacao",nullable = false)
    private int classification;

}
