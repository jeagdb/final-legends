package com.mti.persistence.repository;

import com.mti.persistence.model.StatModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SkillRepository extends CrudRepository<StatModel, Integer> {
    @Override
    Optional<StatModel> findById(Integer integer);
}
