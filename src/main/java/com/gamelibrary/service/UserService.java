package com.gamelibrary.service;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.UserModel;
import com.gamelibrary.repository.UserRepository;
import com.gamelibrary.utils.CustomBeanUtils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private CustomBeanUtils utils;

    @Autowired
    UserRepository userRepository;

    public UserModel saveNewUser(UserModel userModel) {
        userModel.setCreationDate(LocalDateTime.now());
        userModel.setBalance(0.00);
        userModel.setGames(0);
        return userRepository.save(userModel);
    }

    public UserModel saveUser(UserModel userModel) {
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

    public UserModel updateUser(Long id, UserModel userModel) throws CustomException {
        UserModel user = getOneUser(id);
        userModel.setId(id);

        CustomBeanUtils.copyProperties(user, userModel);

        return userRepository.save(userModel);
    }

    public String deleteOneUser(Long id) throws CustomException {
        UserModel user = getOneUser(id);
        userRepository.delete(user);
        return "deleted successfully. ";
    }
}
