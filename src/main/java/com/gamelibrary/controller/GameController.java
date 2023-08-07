package com.gamelibrary.controller;

import com.gamelibrary.model.GameModel;
import com.gamelibrary.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @PostMapping()
    public ResponseEntity<GameModel> saveGame(@RequestBody GameModel gameModel ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameRepository.save(gameModel));
    }
    @GetMapping()
    public ResponseEntity<List<GameModel>> getAllGame() {
        return ResponseEntity.status(HttpStatus.OK).body(gameRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneGame(@PathVariable (value = "id") Long id) {
        Optional<GameModel> gameO = gameRepository.findById(id);
        if(gameO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(gameO.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGame(@PathVariable (value = "id") Long id,@RequestBody GameModel gameModel) {
        Optional<GameModel> gameO = gameRepository.findById(id);
        if(gameO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found. ");
        }
        BeanUtils.copyProperties(gameModel,gameO.get());
        return ResponseEntity.status(HttpStatus.OK).body(gameRepository.save(gameO.get()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneGame (@PathVariable (value = "id") Long id) {
        Optional<GameModel> gameO = gameRepository.findById((id));
        if(gameO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found. ");
        }
        gameRepository.delete(gameO.get());
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted successfully. ");
    }


}
