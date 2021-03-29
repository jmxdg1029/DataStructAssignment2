package com.company;

public class ArrayManager {
    double loadFactor;
    int maxItems;    // records the max size of the table
    int numItems;       // records number of items in the list
    ShopItem[] table; //hashtable itself

    public ArrayManager(int size)
    {
        table = new ShopItem[maxItems];
        maxItems = size;
        numItems = 1;
        loadFactor = 0.75;
    }

    public int hashFunction(Weapon item){
        int value = 0,weight = 1;
        for(int x = 1; x < item.weaponName.length(); x++){
            value+=(item.weaponName.charAt(x)-'a'+1)*weight;
            weight++;
        }
        value+= item.range+item.damage;
        return value%maxItems;
    }

    //insert
    public void put(Weapon item,int quantity) {
        int count = 1;//number of collision
        if (numItems/maxItems <loadFactor){
            int startLoc = hashFunction(item);
            int loc = startLoc;
            while(table[loc] != null) {
                loc = (startLoc+count*count)%maxItems;
                count++;
            }
            table[loc] = new ShopItem(item,quantity);
            numItems++;
            System.out.println(numItems);
        }

    }

    public ShopItem get(String key)
    {
        int location = 0; //gets location in table based on key

        while (location <numItems && key.compareTo(table[location].item.weaponName) != 0)
        {  // not empty and not item
            location++;
        }
        if (location<numItems){
            return table[location];
        }
        return null;
    }

    public void printTable()
    {
        int count = 0;
        for (int x = 0; x < numItems; x++)
        {
            System.out.println("Name: " +table[x].item.weaponName+"   Damage:"+table[x].item.damage+"    Cost:"+table[x].item.cost+"     Quantity in stock:"+table[x].numberInStock);
        }
    }
}

