package com.gamelibrary.controller;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameModel;
import com.gamelibrary.repository.GameRepository;
import com.gamelibrary.service.GameService;
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
    GameService gameService;

    @PostMapping()
    public ResponseEntity<GameModel> saveGame(@RequestBody GameModel gameModel ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.saveGame(gameModel));
    }
    @GetMapping()
    public ResponseEntity<List<GameModel>> getAllGame() {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAllGame());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneGame(@PathVariable (value = "id") Long id) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getOneGame(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGame(@PathVariable (value = "id") Long id,@RequestBody GameModel gameModel) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.updateGame(id,gameModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneGame(@PathVariable (value = "id") Long id) throws CustomException {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.deleteOneGame(id));
    }


}
