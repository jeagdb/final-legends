package com.mti.domain.entity;

public class VocationSkillEntity {
    public final VocationEntity vocationEntity;
    public final SkillEntity skillEntity;

    public VocationSkillEntity(VocationEntity vocationEntity, SkillEntity skillEntity) {
        this.vocationEntity = vocationEntity;
        this.skillEntity = skillEntity;
    }
}
