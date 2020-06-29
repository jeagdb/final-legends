package com.mti.persistence.repository;

import com.mti.domain.entity.DungeonInfoEntity;
import com.mti.persistence.model.DungeonModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DungeonRepository extends CrudRepository<DungeonModel, Integer> {

}
