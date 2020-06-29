package com.mti.persistence.repository;

import com.mti.persistence.model.MonsterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends CrudRepository<MonsterModel, Integer> {
}
