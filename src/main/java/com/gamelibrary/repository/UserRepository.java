package com.gamelibrary.repository;

import com.gamelibrary.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    @Query(
            value = "SELECT * FROM Usuario ORDER BY id",
            countQuery = "SELECT count(*) FROM Usuario",
            nativeQuery = true)
    Page<UserModel> searchAll(Pageable pageable);
}
