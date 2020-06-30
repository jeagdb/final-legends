package com.mti.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="monster_skill")
public class MonsterSkillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="monster_id", referencedColumnName = "id")
    private MonsterModel monsterModel;

    @ManyToOne
    @JoinColumn(name="skill_id", referencedColumnName = "id")
    private SkillModel skillModel;

    public MonsterSkillModel() {
    }

    public MonsterSkillModel(MonsterModel monsterModel, SkillModel skillModel) {
        this.monsterModel = monsterModel;
        this.skillModel = skillModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MonsterModel getMonsterModel() {
        return monsterModel;
    }

    public void setMonsterModel(MonsterModel monsterModel) {
        this.monsterModel = monsterModel;
    }

    public SkillModel getSkillModel() {
        return skillModel;
    }

    public void setSkillModel(SkillModel skillModel) {
        this.skillModel = skillModel;
    }
}
