package com.gamelibrary.controller;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameModel;
import com.gamelibrary.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Page<GameModel> getAllGame(@RequestParam(
            value = ("page"),required = false,defaultValue = "0")int page, @RequestParam(
            value = ("size"),required = false,defaultValue = "10") int size){
        return gameService.getAllGame(page,size);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<GameModel>> getAllGameByFilter(@RequestParam(name = "filter",required = false) String filter) throws CustomException {
        filter.equalsIgnoreCase(filter);
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAllGameByFilter(filter));
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
