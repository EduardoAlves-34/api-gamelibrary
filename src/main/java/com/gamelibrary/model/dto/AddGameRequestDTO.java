package com.gamelibrary.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddGameRequestDTO {

    private Long idGame;

    private Long idUser;

}
