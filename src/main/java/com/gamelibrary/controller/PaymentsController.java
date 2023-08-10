package com.gamelibrary.controller;

import com.gamelibrary.model.UserModel;
import com.gamelibrary.model.dto.AddFundsRequestDTO;
import com.gamelibrary.service.PaymentsService;
import org.apache.catalina.User;
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
    public ResponseEntity<Object> addCredits(@PathVariable Long userId,@RequestBody AddFundsRequestDTO addFundsRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentsService.addFunds(userId,addFundsRequestDTO));
    }




}
