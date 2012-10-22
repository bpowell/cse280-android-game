package edu.oakland.cse280.bscd.models;

import edu.oakland.cse280.bscd.models.Item;

public class Armor extends Item
{

    private int vit;
    private int defense;
    private int minBlock;
    private int maxBlock;

    public Armor(int vit, int defense, int min, int max)
    {

        this.vit = vit;
        this.defense = defense;
        this.minBlock = min;
        this.maxBlock = max;

    }

    public int getVit()
    {

        return this.vit;
    }

    public int getDefense()
    {

        return this.defense;
    }

    public int getMinBlock()
    {

        return this.minBlock;
    }

    public int getMaxBlock()
    {

        return this.maxBlock;
    }
}

    

