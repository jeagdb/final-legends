package com.mti.persistence.repository;

import com.mti.persistence.model.PlayerModel;
import org.springframework.data.repository.CrudRepository;

public interface DungeonRepository extends CrudRepository<PlayerModel, Integer> {
}
