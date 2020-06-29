package com.mti.legend.domain.entity;

import javax.persistence.Entity;

@Entity
public class VocationEntity {
    public final Integer id;
    public final String name;

    public VocationEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
