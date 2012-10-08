package edu.oakland.cse280.tests;

import edu.oakland.cse280.bscd.Inventory;
import java.util.Random;

public class testInventory
{

    public static void main(String args[])
    {
        Inventory inv = new Inventory();

        inv.add(1);
        inv.add(2);
        inv.add(102);
        inv.add(201);

        System.out.println(inv.search(1));
        System.out.println(inv.search(2));
        System.out.println(inv.search(3));
    }
}
