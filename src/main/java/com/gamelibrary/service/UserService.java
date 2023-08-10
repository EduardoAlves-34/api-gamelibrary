package com.gamelibrary.service;

import com.gamelibrary.model.UserModel;
import com.gamelibrary.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel saveUser(UserModel userModel) {
        userModel.setCreationDate(LocalDateTime.now());
        userModel.setBalance(0.00);
        userModel.setGames(0);
        return userRepository.save(userModel);
    }

    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    public Object getOneUser(Long id) {
        Optional<UserModel> userO = userRepository.findById(id);
        if (userO.isEmpty()) {
            return "User not found. ";
        }
        return userO.get();
    }

    public Object updateUser(Long id,UserModel userModel) {
        Optional<UserModel> userO = userRepository.findById(id);
        if(userO.isEmpty()) {
            return "User not found.";
        }
        BeanUtils.copyProperties(userO.get(),userModel);
        return userRepository.save(userModel);
    }

    public String deleteOneUser(Long id) {
        Optional<UserModel> userO = userRepository.findById((id));
        if(userO.isEmpty()) {
            return "User not found. ";
        }
        userRepository.delete(userO.get());
        return "deleted successfully. ";
    }
}
