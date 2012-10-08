package edu.oakland.cse280.tests;

import edu.oakland.cse280.bscd.Inventory;
import edu.oakland.cse280.bscd.InventoryItem;
import java.util.ArrayList;

public class testInventory
{

    public static void main(String args[])
    {
        Inventory inv = new Inventory();
        InventoryItem item = new InventoryItem();
        ArrayList list_of_items = new ArrayList();

        for (int i=1;i<=10;i++ ) 
            inv.addItem(i, 1);
        
        for (int i=101;i<=110;i++ ) 
            inv.addItem(i, 1);

        for (int i=201;i<=210;i++ ) 
            inv.addItem(i, 1);

        for (int i = 1; i<25; i++)
            inv.addItem(201, 1);

        System.out.println(inv.getItemType(1));
        System.out.println(inv.getItemType(2));
        System.out.println(inv.getItemType(3));

        System.out.println(inv.search(201).getCount() + " " + inv.search(201).getItemID());
    }
}
