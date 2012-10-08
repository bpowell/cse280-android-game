package edu.oakland.cse280.bscd;

import java.util.ArrayList;
import edu.oakland.cse280.bscd.InventoryItem;
import java.util.Iterator;

public class Inventory
{
    ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();

    public void addItem(int id, int c)
    {
        Iterator it = items.iterator();
        InventoryItem item = new InventoryItem();
        boolean added = false;
        while(it.hasNext())
        {
            item = (InventoryItem) it.next();
            if (id == item.getItemID())
            {
                item.setCount(item.getCount() + c);
                added = true;
            }
        }
        if(!added)
            items.add(new InventoryItem(id,c));
    }

    public InventoryItem search(int id)
    {
        Iterator it = items.iterator();
        InventoryItem item = new InventoryItem();
        if (it.hasNext())
        {
            while(it.hasNext())
            {
                item = (InventoryItem) it.next();
                if(id==item.getItemID())
                    return item;
            }
            return item;

        }
        else return item;

    }

    public ArrayList getItemType(int type)//type 1=weapons
    {
        ArrayList return_item_list = new ArrayList();
        Iterator it = items.iterator();
        InventoryItem item = new InventoryItem();
        while(it.hasNext())
        {
            item = (InventoryItem) it.next();
            int id = item.getItemID();
            if(id>(type*100-100) && id<=(type*100))
                return_item_list.add(id);
        }

        return return_item_list;
    }


}



