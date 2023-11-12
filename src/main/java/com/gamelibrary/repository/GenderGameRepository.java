package com.gamelibrary.repository;

import com.gamelibrary.model.GameModel;
import com.gamelibrary.model.GenderGameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderGameRepository extends JpaRepository<GenderGameModel, Long> {

    @Query(value = "SELECT ggm.game FROM GenderGameModel ggm where ggm.gender.name = :genero")
    List<GameModel> findGameByGender(@Param("genero") String gender);

}
