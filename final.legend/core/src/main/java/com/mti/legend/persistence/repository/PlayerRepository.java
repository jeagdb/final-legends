package com.mti.legend.persistence.repository;

import com.mti.legend.persistence.model.PlayerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerModel, Integer> {

    @Query(value = "SELECT stat.* FROM stat INNER JOIN player p ON stat.id = p.statId WHERE p.id = ?1", nativeQuery = true)
    void getPlayerStat(final Integer id);

}
