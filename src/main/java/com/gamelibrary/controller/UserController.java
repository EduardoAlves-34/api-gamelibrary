package com.gamelibrary.controller;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameModel;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.repository.UserRepository;
import com.gamelibrary.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(userModel));
    }
    @GetMapping()
    public ResponseEntity<List<UserModel>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable (value = "id") Long id) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOneUser(id));
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
