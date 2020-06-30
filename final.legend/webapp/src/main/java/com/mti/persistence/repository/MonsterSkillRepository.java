package com.mti.persistence.repository;

import com.mti.persistence.model.MonsterSkillModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterSkillRepository extends CrudRepository<MonsterSkillModel, Integer> {
}
