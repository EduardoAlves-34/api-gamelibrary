package com.gamelibrary.repository;

import com.gamelibrary.model.GameModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameModel,Long> {
    //Native Querry
    @Query(
            value = "SELECT * FROM jogo ORDER BY id",
            countQuery = "SELECT count(*) FROM jogo",
            nativeQuery = true)
    Page<GameModel> searchAll(Pageable pageable);

    //Querry method
    //List<GameModel> findByGender(String gender);

    //HQL
    //@Query("SELECT j FROM jogo j WHERE j.value <= ?1 ORDER BY j.value DESC")
    //List<GameModel> findByValue(Double value);

}
