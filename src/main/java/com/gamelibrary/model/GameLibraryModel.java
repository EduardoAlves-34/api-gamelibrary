package com.gamelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "biblioteca_jogos")
@JsonIgnoreProperties({"users","hibernateLazyInitializer","handler"})
public class GameLibraryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UserModel users;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jogo_id")
    private GameModel game;
    @Column(name = "valor")
    private Double value;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private LocalDateTime date;














    //@JoinColumn(name = "")
    //private UserModel giftBy;

}
