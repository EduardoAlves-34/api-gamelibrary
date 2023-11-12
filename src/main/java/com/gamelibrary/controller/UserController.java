package com.gamelibrary.controller;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameLibraryModel;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.repository.GameLibrary;
import com.gamelibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    GameLibrary gameLibrary;

    @PostMapping()
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(userModel));
    }
    @GetMapping()
    public Page<UserModel> getAllUser(@RequestParam(
            value = ("page"),required = false,defaultValue = "0")int page, @RequestParam(
            value = ("size"),required = false,defaultValue = "10") int size) {
        return userService.getAllUser(page,size);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable (value = "id") Long id) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOneUser(id));
    }
    @GetMapping("/historic")
    public ResponseEntity<GameLibraryModel> getPurchaseHistory() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable (value = "id") Long id,@RequestBody UserModel userModel) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,userModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneUser(@PathVariable (value = "id") Long id) throws CustomException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.deleteOneUser(id));
    }

}
