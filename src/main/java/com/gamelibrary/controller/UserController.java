package com.gamelibrary.controller;

import com.gamelibrary.model.GameModel;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.repository.UserRepository;
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
    UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }
    @GetMapping()
    public ResponseEntity<List<UserModel>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable (value = "id") Long id) {
        Optional<UserModel> userO = userRepository.findById(id);
        if(userO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userO.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable (value = "id") Long id,@RequestBody UserModel userModel) {
        Optional<UserModel> userO = userRepository.findById(id);
        if(userO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. ");
        }
        BeanUtils.copyProperties(userModel,userO.get());
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userO.get()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneUser(@PathVariable (value = "id") Long id) {
        Optional<UserModel> userO = userRepository.findById((id));
        if(userO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. ");
        }
        userRepository.delete(userO.get());
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted successfully. ");
    }

}
