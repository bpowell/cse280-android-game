package edu.oakland.cse280.bscd;

import java.util.ArrayList;

public class Inventory
{
    private final int MAX_SIZE = 300;
    private ArrayList items = new ArrayList();

    public boolean add(int i)
    {
        if(!isFull())
            return items.add(i);
        else
            return false;
    }

    public boolean search(int i)
    {
        return items.contains(i);
    }

    public boolean isFull()
    {
        return items.size() == MAX_SIZE;
    }

    public boolean remove(int i)
    {
        return (boolean)items.remove(i);
    }
}
