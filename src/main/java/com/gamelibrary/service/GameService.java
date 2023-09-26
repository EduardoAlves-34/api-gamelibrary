package com.gamelibrary.service;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.GameModel;
import com.gamelibrary.repository.GameRepository;
import com.gamelibrary.repository.GenderGameModelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GenderGameModelRepository genderGameModelRepository;

    public GameModel saveGame(GameModel gameModel ) {
        return gameRepository.save(gameModel);
    }

    public Page<GameModel> getAllGame(
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "id");
        return gameRepository.searchAll(pageRequest);
    }

    public List<GameModel> getAllGameByFilter(String filter) throws CustomException {
        genderGameModelRepository.findtest();
        throw new CustomException("Tipo de Filtro invalido . ", 404);
    }

    public GameModel getOneGame(Long id) throws CustomException {
        var game = gameRepository.findById(id);
        if(game.isPresent()) {
            return game.get();
        }
        throw new CustomException("Game not found. ",404);
    }

    public GameModel updateGame(Long id,GameModel gameModel) throws CustomException {
        var game = getOneGame(id);
        gameModel.setId(id);
        BeanUtils.copyProperties(gameModel,game);
        return gameRepository.save(game);
    }

    public String deleteOneGame(Long id) throws CustomException {
        var game = getOneGame((id));
        gameRepository.delete(game);
        return "deleted successfully. ";
    }

}
