package edu.oakland.cse280.bscd.entities;

import edu.oakland.cse280.bscd.entities.Mob;
import java.lang.Math;

public class EnemyMob extends Mob
{

    private int attack;
    private int strength;
    private int defense;
    private int vit;
    private int minDamage;
    private int maxDamage;
    private int expToGive;
    private int hp;
    private int[] itemToGive;  /// need to figure out how to pass an array from the database
    private boolean isAlive = true;
    private int R;
    private int G;
    private int B;

    public EnemyMob(int id, String name, int strength, int attack, int defense, int vit, int min, int max, int exp, int r, int g, int b)
    {
        super(id, name);
        this.strength = strength;
        this.attack = attack;
        this.defense = defense;
        this.vit = vit;
        this.minDamage = min;
        this.maxDamage = max;
        this.expToGive = exp;
        this.hp = vit*5;

	this.R = r;
	this.G = g;
	this.B = b;
    }

    public void setStrength(int s)
    {
    
        this.strength = s;
    }

    public void setAttack(int a)
    {

        this.attack = a;
    }

    public void setDefense(int d)
    {

        this.defense = d;
    }

    public void setVit(int v)
    {

        this.vit = vit;
    }

    public void setMinDamage(int min)
    {

        this.minDamage = min;
    }

    public void setMaxDamage(int max)
    {

        this.maxDamage = max;
    }

    public void setHP(int hp)
    {

        this.hp = hp;
    }

    public int getAttack()
    {

        return this.attack;
    }

    public int getHP()
    {

        return this.hp;
    }

    public int getMin()
    {

        return this.minDamage;
    }

    public int getMax()
    {

        return this.maxDamage;
    }

    public int getStrength()
    {

        return this.strength;
    }

    public int getExp()
    {

        return expToGive;
    }


    // figure out the items to give on death
    //
    //
    //
    public int doDamage(int weaponMin, int weaponMax, int heroStrength)
    {

        int damage = ((weaponMin + (int)(Math.random() * ((weaponMax - weaponMin) + 1))) + heroStrength) - this.defense;

        damage = (damage < 1) ? 1 : damage; 

        hp -=damage;

        if (hp<=0)
            this.isAlive = false;

        return damage;
    }

    public boolean isAlive()
    {

        return this.isAlive;
    }

    public int getR()
    {
	    return this.R;
    }

    public void setR(int  R)
    {
	    this.R = R;;
    }

    public int getG()
    {
	    return this.G;
    }

    public void setG(int  G)
    {
	    this.G = G;;
    }

    public int getB()
    {
	    return this.B;
    }

    public void setB(int  B)
    {
	    this.B = B;;
    }

}

