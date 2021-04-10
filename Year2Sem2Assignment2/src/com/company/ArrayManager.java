//John Michael De Guzman 101248107
//Gabriel Silva 101245036
//Ruzzel Orejola 1013474777
package com.company;

public class ArrayManager {
    double loadFactor;
    int maxItems;    // records the max size of the table
    int numItems;       // records number of items in the list
    ShopItem[] table; //hashtable itself

    public ArrayManager(int size)
    {
        maxItems = size;
        table = new ShopItem[maxItems];
        numItems = 0;
        loadFactor = 0.75;
    }

    public int hashFunction(String weapName){
        int value = 0,weight = 1;
        for(int x = 0; x < weapName.length(); x++){
            value+=(weapName.charAt(x)-'a'+1)*weight;
            weight++;
        }
        return value%maxItems;
    }

    //insert
    public void put(Weapon item,int quantity) {
        int count = 1;//number of collision
        if (numItems/maxItems <loadFactor){
            int startLoc = hashFunction(item.weaponName);
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

    public ShopItem get(String weapName) {
        int count = 1;
        int startLoc = hashFunction(weapName);
        int location = startLoc; //gets location in table based on key
        if (table[location] == null){
            return null;
        }
        while (location < numItems && weapName.compareTo(table[location].item.weaponName) != 0)
        {//not empty and not item
            location = (startLoc + count * count) % maxItems;
            count++;
        }
        return table[location];
    }

    public int nameCheck(String weapName){
        int count = 1;
        int startLoc = hashFunction(weapName);
        int location = startLoc; //gets location in table based on key
        if (table[location] == null){
            return -1;
        }
        while (location < numItems && weapName.compareTo(table[location].item.weaponName) != 0)
        {//not empty and not item
            location = (startLoc + count * count) % maxItems;
            count++;
        }

        return location;
    }

    public Boolean addStock(String weapName, int quantity){
        if(nameCheck(weapName) != -1){
            table[nameCheck(weapName)].numberInStock += quantity;
            System.out.println(table[nameCheck(weapName)].numberInStock);
            return true;
        }else{
            return false;
        }
    }

    public boolean removeItem(String word){
        int count = 1;
        int startLoc = hashFunction(word);
        int loc = startLoc;
        while(table[loc] != null && table[loc].item.weaponName.compareTo(word) != 0){
            loc = (startLoc + count * count) % maxItems;
            count++;
        }
        if(table[loc] != null){
            table[loc] = null;
            numItems--;
            return true;
        }
        return false;
    }

    public void printTable()
    {
        int count = 0;
        for (int x = 0; x < maxItems; x++)
        {
            if(table[x] != null)
            {
                System.out.println("Name: " + table[x].item.weaponName + " Damage: "+ table[x].item.damage+ " Cost: "+table[x].item.cost + " Stock: "+table[x].numberInStock);
            }
        }
    }


}

