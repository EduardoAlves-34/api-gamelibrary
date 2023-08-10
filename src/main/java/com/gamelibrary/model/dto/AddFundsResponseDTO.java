package com.gamelibrary.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AddFundsResponseDTO {

    private Double balance;
    private String msg;
    private LocalDateTime dateTime;
}
