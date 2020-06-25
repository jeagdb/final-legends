package com.mti.persistence.repository;

import com.mti.persistence.model.PlayerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<PlayerModel, Integer> {

    @Query(value = "", nativeQuery = false)
    void getPlayerStat(final String login);

}
