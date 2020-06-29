package com.mti.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="monster")
public class MonsterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer xp;

    @ManyToOne
    @JoinColumn(name="stat_id", referencedColumnName = "id")
    private StatModel statModel;

    public MonsterModel() {

    }

    public MonsterModel(Integer id, String name, Integer xp, StatModel statModel) {
        this.id = id;
        this.name = name;
        this.xp = xp;
        this.statModel = statModel;
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

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public StatModel getStatModel() {
        return statModel;
    }

    public void setStatModel(StatModel statModel) {
        this.statModel = statModel;
    }
}
