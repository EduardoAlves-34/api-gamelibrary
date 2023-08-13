package com.gamelibrary.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorDTO {

    private String msg;
    private Integer code;
    private LocalDateTime timesTamp;

}
