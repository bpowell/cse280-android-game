package edu.oakland.cse280.bscd;

public class InventoryItem
{

    int itemid;
    int count;

    public InventoryItem(int id, int c)
    {

        this.itemid = id;
        this.count = c;
    }
    public InventoryItem()
    {


    }

    public int getItemID()
    {

        return this.itemid;
    }

    public int getCount()
    {

        return this.count;
    }

    public void setItemID(int id)
    {

        this.itemid = id;
    }

    public void setCount(int c)
    {

        this.count = c;
    }


    
    

}
