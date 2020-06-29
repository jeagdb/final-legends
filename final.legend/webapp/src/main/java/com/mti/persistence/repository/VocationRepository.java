package com.mti.persistence.repository;

import com.mti.persistence.model.VocationModel;
import org.springframework.data.repository.CrudRepository;

public interface VocationRepository extends CrudRepository<VocationModel, Integer> {
}
