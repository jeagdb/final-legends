package com.mti.persistence.repository;

import com.mti.persistence.model.DungeonModel;
import com.mti.persistence.model.PlayerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DungeonRepository extends CrudRepository<DungeonModel, Integer> {
}
