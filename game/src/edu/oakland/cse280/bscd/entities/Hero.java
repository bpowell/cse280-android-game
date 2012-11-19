package edu.oakland.cse280.bscd.entities;

import edu.oakland.cse280.bscd.entities.Mob;
import edu.oakland.cse280.bscd.models.Weapon;
import edu.oakland.cse280.bscd.models.Armor;
import java.lang.Math;

import android.util.Log;

public class Hero extends Mob
{

    private int attack;
    private int strength;
    private int defense;
    private int vit;
    private int hp;
    private int maxHP;
    private boolean isAlive = true;
    private final int LEVEL_1 = 100;
    private final int LEVEL_2 = 200;
    private final int LEVEL_3 = 300;
    private final int LEVEL_4 = 400;
    private final int LEVEL_5 = 500;
    private final int LEVEL_6 = 600;
    private final int LEVEL_7 = 700;
    private final int LEVEL_8 = 800;
    private final int LEVEL_9 = 900;
    private final int LEVEL_10 = 1000;
    private int exp = 0;
    private int helmDefense = 0;
    private int chestDefense = 0;
    private int gloveDefense = 0;
    private int bootDefense = 0;
    private int level = 1;

    public Hero(int id, String name, int strength, int attack, int defense, int vit)
    {
        super(id, name);
        this.strength = strength;
        this.attack = attack;
        this.defense = defense;
        this.vit = vit;
        this.maxHP = vit * 10;
        this.hp = maxHP;
    }
    
    public Hero(int id, String name, int level, int vit)
    {
        super(id, name);
        this.level = level;
        this.vit = vit;
    }

    public Hero(String name, int level)
    {
        super.setName(name);
        this.level = level;
    }

    public Hero()
    {
        super();
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
        for(int i=0;i<10;i++)
            Log.i("vit was set to ", ""+vit);
        this.vit = vit;
    }

    public void setHP(int hp)
    {

        this.hp = hp;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void setHelm(Armor armor)
    {

        this.helmDefense = armor.getDefense();
    }

    public void setChest(Armor armor)
    {

        this.chestDefense = armor.getDefense();
    }

    public void setGloves(Armor armor)
    {

        this.gloveDefense = armor.getDefense();
    }

    public void setBoots(Armor armor)
    {

        this.bootDefense = armor.getDefense();
    }

    public void setWeapon(Weapon weapon)
    {

        this.attack = weapon.getAttack();
        this.strength = weapon.getStrength();
    }

    public int getAttack()
    {

        return this.attack;
    }

    public int getHP()
    {

        return this.hp;
    }

    public int getStrength()
    {

        return this.strength;
    }

    public int getLevel()
    {

        return this.level;
    }

    public int getVit()
    {
        return this.vit;
    }

    public int doDamage(int min, int max, int enemyStrength)
    {
        
        int damage = ((min + (int)(Math.random() * ((max - min) + 1))) + enemyStrength) - this.defense;

        if (damage < 1)
            damage = 1;

        hp -= damage;
        if (hp<=0)
            this.isAlive = false;
            
        return damage;
    }

    public boolean isAlive()
    {

        return this.isAlive;
    }

    public int getDefense()
    {

        return defense + helmDefense + chestDefense + gloveDefense + bootDefense;
    }

    public boolean level(int exp)
    {
        int prevLevel = this.level;
        this.exp += exp;

        if (exp >= LEVEL_2 && exp < LEVEL_3)
            this.level = 2;

        if (exp >= LEVEL_3 && exp < LEVEL_4)
            this.level = 3;

        if (exp >= LEVEL_4 && exp < LEVEL_5)
            this.level = 4;

        if (exp >= LEVEL_5 && exp < LEVEL_6)
            this.level = 5;

        if (exp >= LEVEL_6 && exp < LEVEL_7)
            this.level = 6;

        if (exp >= LEVEL_7 && exp < LEVEL_8)
            this.level = 7;

        if (exp >= LEVEL_8 && exp < LEVEL_9)
            this.level = 8;

        if (exp >= LEVEL_9 && exp < LEVEL_10)
            this.level = 9;

        if (exp >= LEVEL_10)
            this.level = 10;

        return prevLevel < this.level;
    }
}

