package edu.oakland.cse280.bscd.test;

import edu.oakland.cse280.bscd.entities.*;

import edu.oakland.cse280.bscd.models.Weapon;
import edu.oakland.cse280.bscd.models.Armor;

public class TestFight
{

    
    public static void main(String args[])
    {

        // strength, attack, defense, vit 
        Hero hero = new Hero(1, "Bob", 1,10, 10, 10, 10, 0,0);
        EnemyMob enemy = new EnemyMob(1, "Wilber", 10, 9, 10, 10, 2, 20, 201, 0,0,0);
        // attack, strength, min, max
        Weapon weapon = new Weapon(5, 10, 3, 15);
        // vit, defense, min, max
        Armor helm = new Armor(1, 5, 0, 0);
        Armor chest = new Armor(1, 5, 0, 0);
        Armor gloves = new Armor(1, 5, 0, 0);
        Armor boots = new Armor(1, 5, 0, 0);

        hero.setHelm(helm);
        hero.setChest(chest);
        hero.setGloves(gloves);
        hero.setBoots(boots);
        hero.setWeapon(weapon);

        if(enemy.getAttack() >= hero.getAttack())
            enemyGoesFirst(enemy, hero, weapon);
        else
            heroGoesFirst(enemy, hero, weapon);

    }
    
    public static void enemyGoesFirst(EnemyMob enemy, Hero hero, Weapon weapon)
    {

        while (true)
        {
            System.out.println("");
            System.out.println("Enemy HP = " + enemy.getHP());
            System.out.println("Hero HP = "+ hero.getHP());
            System.out.println("ENEMY ATTACKING");
            System.out.println("Enemy hits for " + hero.doDamage(enemy.getMin(), enemy.getMax(), enemy.getStrength()));
            System.out.println("Hero HP = " + hero.getHP());

            if (!hero.isAlive()) 
            {
                System.out.println("You Are Dead!!!!");
                break;
            }
            System.out.println("HERO IS ATTACKING");
            System.out.println("Hero hits for " + enemy.doDamage(weapon.getMinDamage(), weapon.getMaxDamage(), hero.getStrength()));

            if (!enemy.isAlive())
            {
                System.out.println("Enemy is Dead");
                if (hero.level(enemy.getExp()))
                {

                    System.out.println("You leveled!!!");
                    System.out.println("Your Level is " + hero.getLevel());
                }

                break;
            }
        }
    }

    public static void heroGoesFirst(EnemyMob enemy, Hero hero, Weapon weapon)
    {

        while (true)
        {
            System.out.println("");
            System.out.println("Enemy HP = " + enemy.getHP());
            System.out.println("Hero HP = "+ hero.getHP());
            System.out.println("HERO ATTACKING");
            System.out.println("HERO hits for " + enemy.doDamage(weapon.getMinDamage(), weapon.getMaxDamage(), hero.getStrength()));
            System.out.println("enemy HP = " + enemy.getHP());

            if (!enemy.isAlive()) 
            {
                System.out.println("Enemy is Dead!!!!");
                if (hero.level(enemy.getExp()))
                {

                    System.out.println("You leveled!!!");
                    System.out.println("Your Level is " + hero.getLevel());
                }

                break;
            }
            System.out.println("ENEMY IS ATTACKING");
            System.out.println("Enemy hits for " + hero.doDamage(enemy.getMin(), enemy.getMax(), enemy.getStrength()));

           
            if (!hero.isAlive())
            {

                System.out.println("You are dead!!");
                break;
            }
        }
    }

}
