package edu.oakland.cse280.bscd.models;

import edu.oakland.cse280.bscd.models.Item;

public class StatBoostItem extends Item
{

    private int attack;
    private int strength;
    private int vit;
    private int defense;
    private int hp;
    private boolean hasDuration;
    private long duration;

    public StatBoostItem(int attack, int strength, int vit, int defense, int hp, boolean hasDuration, long duration)
    {

        this.attack = attack;
        this.strength = strength;
        this.vit = vit;
        this.defense = defense;
        this.hp = hp;
        this.hasDuration = hasDuration;
        this.duration = duration;
    }

    public int getAttack()
    {

        return this.attack;
    }

    public int getStrength()
    {

        return this.strength;
    }

    public int getVit()
    {

        return this.vit;
    }

    public int getHP()
    {

        return this.hp;
    }

    public boolean getHasDuration()
    {

        return this.hasDuration;
    }

    public long getDuration()
    {

        return this.duration;
    }
}
