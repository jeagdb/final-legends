package com.mti.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="vocation_skill")
public class VocationSkillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="vocation_id", referencedColumnName = "id")
    private VocationModel vocationModel;

    @ManyToOne
    @JoinColumn(name="skill_id", referencedColumnName = "id")
    private SkillModel skillModel;

    public VocationSkillModel() {
    }

    public VocationSkillModel(VocationModel vocationModel, SkillModel skillModel) {
        this.vocationModel = vocationModel;
        this.skillModel = skillModel;
    }

    public VocationModel getVocationModel() {
        return vocationModel;
    }

    public void setVocationModel(VocationModel vocationModel) {
        this.vocationModel = vocationModel;
    }

    public SkillModel getSkillModel() {
        return skillModel;
    }

    public void setSkillModel(SkillModel skillModel) {
        this.skillModel = skillModel;
    }
}
