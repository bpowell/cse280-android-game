package edu.oakland.cse280.tests;

import edu.oakland.cse280.bscd.Inventory;
import java.util.Random;

public class testInventory
{

    public static void main(String args[])
    {
        Inventory inv = new Inventory();
        Random r = new Random();

        for (int i = 0; i<10; i++)
        {
            int num = r.nextInt(400) + 1;

            if(inv.add(num))
            {
                System.out.println("Added random number " + num);

                if(inv.search(num))
                {
                    if (num>0 && num <= 100)
                        System.out.println("Weapon " + num + " selected");
                    else if(num > 0 && num <= 200)
                        System.out.println("Armor " + (num-100) + " selected");
                    else if(num > 200 && num <= 300)
                        System.out.println("Item " + (num - 200) + " selected");
                    else 
                        System.out.println("Number is out of range "+ num);
                }
                else 
                    System.out.println(num + " is not in the bag");

            }
            else
                System.out.println("bag is full");
        }
    }
}
