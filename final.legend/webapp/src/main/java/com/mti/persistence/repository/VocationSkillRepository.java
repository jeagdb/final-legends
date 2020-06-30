package com.mti.persistence.repository;

import com.mti.persistence.model.VocationSkillModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocationSkillRepository extends CrudRepository<VocationSkillModel, Integer> {
}
