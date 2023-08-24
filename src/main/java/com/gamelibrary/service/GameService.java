package com.gamelibrary.service;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameModel;
import com.gamelibrary.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public GameModel saveGame(GameModel gameModel ) {
        return gameRepository.save(gameModel);
    }

    public List<GameModel> getAllGame() {
        return gameRepository.findAll();
    }

    public GameModel getOneGame(Long id) throws CustomException {
        var game = gameRepository.findById(id);
        if(game.isPresent()) {
            return game.get();
        }
        throw new CustomException("Game not found. ");
    }

    public GameModel updateGame(Long id,GameModel gameModel) throws CustomException {
        var game = getOneGame(id);
        gameModel.setId(id);
        BeanUtils.copyProperties(gameModel,game);
        return gameRepository.save(game);
    }

    public String deleteOneGame(Long id) throws CustomException {
        var game = getOneGame((id));
        gameRepository.delete(game);
        return "deleted successfully. ";
    }

}
