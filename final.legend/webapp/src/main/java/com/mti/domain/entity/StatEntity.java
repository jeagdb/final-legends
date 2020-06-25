package com.mti.domain.entity;

public class StatEntity {
    public final Integer id;
    public final Integer health;
    public final Integer mana;
    public final Integer attack;
    public final Integer defense;
    public final Integer intelligence;
    public final Integer agility;

    public StatEntity(Integer id, Integer health, Integer mana, Integer attack, Integer defense, Integer intelligence, Integer agility) {
        this.id = id;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.intelligence = intelligence;
        this.agility = agility;
    }
}
