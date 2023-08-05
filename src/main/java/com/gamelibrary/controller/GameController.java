package com.gamelibrary.controller;

import com.gamelibrary.model.GameModel;
import com.gamelibrary.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @PostMapping("/game")
    public ResponseEntity<GameModel> saveGame(@RequestBody GameModel gameModel ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameRepository.save(gameModel));
    }
    @GetMapping("/game")
    public ResponseEntity<List<GameModel>> getAllGame() {
        return ResponseEntity.status(HttpStatus.OK).body(gameRepository.findAll());
    }
    @GetMapping("/game/{id}")
    public ResponseEntity<Object> getOneGame(@PathVariable (value = "id") Long id) {
        Optional<GameModel> gameO = gameRepository.findById(id);
        if(gameO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(gameO.get());
    }
    


}
