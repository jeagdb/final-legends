package com.mti.legend.persistence.repository;

import com.mti.legend.persistence.model.PlayerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DungeonRepository extends CrudRepository<PlayerModel, Integer> {
}
