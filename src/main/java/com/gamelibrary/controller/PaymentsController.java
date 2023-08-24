package com.gamelibrary.controller;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.model.dto.AddFundsRequestDTO;
import com.gamelibrary.model.dto.AddGameResquetDTO;
import com.gamelibrary.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/credits")
public class PaymentsController {

    @Autowired
    PaymentsService paymentsService;

    @PostMapping("/addfunds/user/{userId}")
    public ResponseEntity<Object> addCredits(@PathVariable Long userId,@RequestBody AddFundsRequestDTO addFundsRequestDTO) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK).body(paymentsService.addFunds(userId,addFundsRequestDTO));
    }

    @PostMapping("/buygame/user")
    public UserModel buyGame(@RequestBody AddGameResquetDTO addGameResquetDTO) throws CustomException {
        System.out.println("REQUESTE" + addGameResquetDTO.getIdGame()+ addGameResquetDTO.getIdUser());
        return paymentsService.buyGame(addGameResquetDTO);
    }



}
