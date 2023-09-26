package com.gamelibrary.service;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameModel;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.model.dto.AddFundsRequestDTO;
import com.gamelibrary.model.dto.AddFundsResponseDTO;
import com.gamelibrary.model.dto.AddGameRequestDTO;
import com.gamelibrary.model.dto.AddGiftGameRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public UserModel buyGame(AddGameRequestDTO addGameRequestDTO) throws CustomException {
        var user = userService.getOneUser(addGameRequestDTO.getIdUser());
        var game = gameService.getOneGame(addGameRequestDTO.getIdGame());
            int n = user.getListgames().size();
            // FOR INDEX
            for(int i = 0; i<n; i++) {
              GameModel item = user.getListgames().get(i);
              if(item.getId() == game.getId()) {
                  throw new CustomException("Você já possui este jogo. ",409);
              }
            }
            if (user.getBalance() >= game.getValue()) {
                user.setBalance(user.getBalance() - game.getValue());
                user.setGames(user.getGames() + 1);
                user.getListgames().add(game);
                userService.saveUser(user);
                return user;
            } else {
                throw new CustomException("insufficient balance. ",402);
            }
    }

    public UserModel buyGiftGame(AddGiftGameRequestDTO addGiftGameRequestDTO) throws CustomException {
        var userBuy = userService.getOneUser(addGiftGameRequestDTO.getIdUser());
        var userGift = userService.getOneUser(addGiftGameRequestDTO.getIdUserGift());
        var game = gameService.getOneGame(addGiftGameRequestDTO.getIdGame());
        // FOREACH
        for(GameModel item : userGift.getListgames()) {
            if(item.getId() == game.getId()) {
                throw new CustomException("Este usuario já possui este jogo. ",409);
            }
        }
        if(userBuy.getBalance() >= game.getValue()) {
            userBuy.setBalance(userBuy.getBalance() - game.getValue());
            userGift.setGames(userGift.getGames() + 1);
            userGift.getListgames().add(game);
            userService.saveUser(userGift);
            return userGift;
        } else {
            throw new CustomException("insufficient balance. ",402);
        }
    }


}
