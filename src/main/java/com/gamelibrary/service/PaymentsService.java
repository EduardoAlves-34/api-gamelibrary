package com.gamelibrary.service;

import com.gamelibrary.model.UserModel;
import com.gamelibrary.model.dto.AddFundsRequestDTO;
import com.gamelibrary.model.dto.AddFundsResponseDTO;
import com.gamelibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PaymentsService {

    @Autowired
    UserRepository userRepository;

    public Object addFunds(Long id,AddFundsRequestDTO addFundsRequestDTO) {
        Optional<UserModel> userO = userRepository.findById(id);
        if(userO.isEmpty()){
            return "User not found. ";
        }
        userO.get().setBalance(userO.get().getBalance() + addFundsRequestDTO.getValue());
        userRepository.save(userO.get());
        AddFundsResponseDTO response = new AddFundsResponseDTO();
        response.setBalance(userO.get().getBalance());
        response.setMsg("sucesso");
        response.setDateTime(LocalDateTime.now());
        return response;
    }

}
