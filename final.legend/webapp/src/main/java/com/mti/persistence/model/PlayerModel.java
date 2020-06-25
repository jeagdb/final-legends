package com.mti.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="player")
public class PlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer level;

    @ManyToOne
    @JoinColumn(name="classId", referencedColumnName = "id")
    private ClassModel classModel;

    @ManyToOne
    @JoinColumn(name="statId", referencedColumnName = "id")
    private StatModel statModel;

    @Column
    private Integer experience;

    public PlayerModel() {
    }

    public PlayerModel(Integer id, String name, Integer level, ClassModel classModel, StatModel statModel, Integer experience) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.classModel = classModel;
        this.statModel = statModel;
        this.experience = experience;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public ClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }

    public StatModel getStatModel() {
        return statModel;
    }

    public void setStatModel(StatModel statModel) {
        this.statModel = statModel;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}
