package com.mti.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="stat")
public class StatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer health;

    @Column
    private Integer mana;

    @Column
    private Integer attack;

    @Column
    private Integer defense;

    @Column
    private Integer intelligence;

    @Column
    private Integer agility;

    public StatModel() {
    }

    public StatModel(Integer id, Integer health, Integer mana, Integer attack, Integer defense, Integer intelligence, Integer agility) {
        this.id = id;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }
}
