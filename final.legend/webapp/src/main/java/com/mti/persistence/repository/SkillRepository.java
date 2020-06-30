package com.mti.persistence.repository;

import com.mti.persistence.model.SkillModel;
import com.mti.persistence.model.StatModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends CrudRepository<SkillModel, Integer> {
    @Override
    Optional<SkillModel> findById(Integer integer);
}
