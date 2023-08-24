package com.gamelibrary.service;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameModel;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.model.dto.AddFundsRequestDTO;
import com.gamelibrary.model.dto.AddFundsResponseDTO;
import com.gamelibrary.model.dto.AddGameResquetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentsService {

    @Autowired
    UserService userService;
    @Autowired
    GameService gameService;

    public Object addFunds(Long id, AddFundsRequestDTO addFundsRequestDTO) throws CustomException {
        var user = userService.getOneUser(id);
        if (user.getBalance() == null) {
            user.setBalance(0.0);
        }
        user.setBalance(user.getBalance() + addFundsRequestDTO.getValue());
        userService.saveUser(user);
        AddFundsResponseDTO response = new AddFundsResponseDTO();
        response.setBalance(user.getBalance());
        response.setMsg("sucesso");
        response.setDateTime(LocalDateTime.now());
        return response;
    }

    public UserModel buyGame(AddGameResquetDTO addGameResquetDTO) throws CustomException {
        var user = userService.getOneUser(addGameResquetDTO.getIdUser());
        var game = gameService.getOneGame(addGameResquetDTO.getIdGame());
            int n = user.getListgames().size();
            for(int i = 0; i<n; i++ ) {
              GameModel item = user.getListgames().get(i);
              if(item.getId() == game.getId()) {
                  throw new CustomException("Você já possui este jogo. ");
              }
            }
            if (user.getBalance() >= game.getValue()) {
                user.setBalance(user.getBalance() - game.getValue());
                user.setGames(user.getGames() + 1);
                user.getListgames().add(game);
                userService.saveUser(user);
                return user;
            } else {
                throw new CustomException("insufficient balance. ");
            }
    }


}
