package com.gamelibrary.service;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

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

    public UserModel getOneUser(Long id) throws CustomException {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new CustomException("User not found. ");
    }

    public Object updateUser(Long id,UserModel userModel) throws CustomException {
        var user = getOneUser(id);
        BeanUtils.copyProperties(user,userModel);
        return userRepository.save(userModel);
    }

    public String deleteOneUser(Long id) throws CustomException {
        var user = getOneUser(id);
        userRepository.delete(user);
        return "deleted successfully. ";
    }
}
