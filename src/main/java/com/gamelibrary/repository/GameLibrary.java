package com.gamelibrary.repository;

import com.gamelibrary.model.GameLibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLibrary extends JpaRepository<GameLibraryModel,Long> {

}
