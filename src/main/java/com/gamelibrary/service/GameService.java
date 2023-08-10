package com.gamelibrary.service;

import com.gamelibrary.model.GameModel;
import com.gamelibrary.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    public Object getOneGame(Long id) {
        Optional<GameModel> gameO = gameRepository.findById(id);
        if(gameO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found. ");
        }
        return gameO.get();
    }

    public Object updateGame(Long id,GameModel gameModel) {
        Optional<GameModel> gameO = gameRepository.findById(id);
        if(gameO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found. ");
        }
        BeanUtils.copyProperties(gameO.get(),gameModel);
        return gameRepository.save(gameO.get());
    }

    public String deleteOneGame(Long id) {
        Optional<GameModel> gameO = gameRepository.findById((id));
        if(gameO.isEmpty()) {
            return "Game not found. ";
        }
        gameRepository.delete(gameO.get());
        return "deleted successfully. ";
    }

}
