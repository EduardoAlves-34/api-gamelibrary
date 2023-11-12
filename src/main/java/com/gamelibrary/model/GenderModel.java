package com.gamelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "genero")
@JsonIgnoreProperties({"games","hibernateLazyInitializer","handler"})
public class GenderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",length = 50,nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "genero_jogos",
            joinColumns = @JoinColumn(name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "jogo_id"))
    List<GameModel> games;

}
