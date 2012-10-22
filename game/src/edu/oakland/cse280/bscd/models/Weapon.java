package edu.oakland.cse280.bscd.models;

import edu.oakland.cse280.bscd.models.Item;

public class Weapon extends Item
{

    private int attack;
    private int strength;
    private int minDamage;
    private int maxDamage;

    public Weapon(int attack, int strength, int min, int max)
    {

        this.attack = attack;
        this.strength = strength;
        this.minDamage = min;
        this.maxDamage = max;
    }

    public int getAttack()
    {

        return this.attack;
    }

    public int getStrength()
    {

        return this.strength;
    }

    public int getMinDamage()
    {

        return this.minDamage;
    }

    public int getMaxDamage()
    {

        return this.maxDamage;
    }

    {


    }
}
    

