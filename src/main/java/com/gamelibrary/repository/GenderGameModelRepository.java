package com.gamelibrary.repository;

import com.gamelibrary.model.GenderGameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderGameModelRepository extends JpaRepository<GenderGameModel, Long> {


    @Query(value = "select m from GenderGameModel as m", nativeQuery = true)
    public List<GenderGameModel> findtest();

}
