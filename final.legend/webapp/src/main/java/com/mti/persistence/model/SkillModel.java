package com.mti.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="skill")
public class SkillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer damage;

    @Column
    private Integer cost;

    public SkillModel() {
    }

    public SkillModel(Integer id, String name, Integer damage, Integer cost) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.cost = cost;
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

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
