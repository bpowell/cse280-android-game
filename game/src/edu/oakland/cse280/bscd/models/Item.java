package edu.oakland.cse280.bscd.models;

public class Item
{

    private String name;
    private String description;
    private int id;

    public void setName(String name)
    {

        this.name = name;
    }

    public void setDescription(String desc)
    {

        this.description = desc;
    }

    public void setID(int id)
    {

        this.id = id;
    }

    public String getName()
    {

        return this.name;
    }

    public String getDescription()
    {

        return this.description;
    }

    public int getID()
    {

        return this.id;
    }
}
