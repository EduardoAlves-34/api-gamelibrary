package com.gamelibrary.repository;

import com.gamelibrary.model.GenderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderModel,Long> {

}
