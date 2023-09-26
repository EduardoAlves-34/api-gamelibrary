package com.gamelibrary.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddGiftGameRequestDTO {

    private Long idUser;

    private Long idUserGift;

    private Long idGame;

}
