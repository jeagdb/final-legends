package com.mti.persistence.repository;

import com.mti.persistence.model.StatModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<StatModel, Integer> {
}
