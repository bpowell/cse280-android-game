package edu.oakland.cse280.bscd.entities;

public class Mob
{

    private String name;
    private int id;

    public Mob(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Mob()
    {

    }

    public void setId(int id)
    {
        this.id = id;
    }

    public  void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {

        return this.name;
    }

    public int getId()
    {
        return this.id;
    }
}
