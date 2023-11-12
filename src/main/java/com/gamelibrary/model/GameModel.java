package com.gamelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "jogo")
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 50, nullable = false)
    private String name;
    @Column(name = "valor", nullable = false)
    private Double value;
    @Column(name = "descricao", length = 100, nullable = false)
    private String description;
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;
    @Column(name = "tamanho_gb", nullable = false)
    private Double sizeGB;
    @Column(name = "distribuidora", length = 50, nullable = false)
    private String distributor;
    @Column(name = "classificacao", nullable = false)
    private int classification;

    @ManyToMany(mappedBy = "games")
    private List<GenderModel> gender;

}
