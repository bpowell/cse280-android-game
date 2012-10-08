package edu.oakland.cse280.bscd;

import java.util.ArrayList;
import edu.oakland.cse280.bscd.InventoryItem;

public class Inventory
{
    private final int MAX_SIZE = 300;
    private ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();

    public boolean add(int i)
    {
        if(!isFull())
//            if(items.contains(i))
//            {
//                int j = items.indexOf(i);
//                return  items[j].setCount(1);
//            }
//            else
                return items.add(new InventoryItem(i));
        else
            return false;
    }

    public ArrayList<String> search(int i)
    {
        ArrayList<String> itemList = new ArrayList<String>();
        if(i==1)
        {
            for (int j=0;j<items.size() ;j++ )
            {
                if(items.get(i).getItemType() > 0 && items.get(i).getItemType() <= 100)
                    itemList.add(items.get(j).getCount() + " " + items.get(j).getName());
            }
        }
        else if (i==2)
        {
            for (int j = 0; j<items.size(); j++ )
            {
                if(items.get(j).getItemType() > 100 && items.get(j).getItemType() <= 200)
                    itemList.add(items.get(j).getCount() + " " + items.get(j).getName());
            }
        }
        else if (i==3)
        {
            for (int j = 0; j<items.size(); j++ )
            {
                if(items.get(j).getItemType() > 200 && items.get(j).getItemType() <= 300)
                    itemList.add(items.get(j).getCount() + " " +items.get(j).getName());
            }
        }

        return itemList;
    }

    public boolean isFull()
    {
        return items.size() == MAX_SIZE;
    }

  //  public boolean remove(int i)
  //  {
  //      if(items.contains(i) && items.indexOf(i).getCount() > 1)
  //         return  items.indexOf(i).setCount(-1);
  //      else if(items.contains(i) && items.indexOf(i).getCount() == 1)
  //         return  items.remove(i);
  //      else
  //          return false;
  //  }
}
