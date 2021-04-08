package com.company;

public class Backpack {

    private LinkedList[] table;
    int maxItems;
    int numItems;
    double currWeight;
    double maxWeight;

    public Backpack(int size){
        maxItems = size;
        table = new LinkedList[maxItems];
    }

    /* Function myhash */
    public int hashFunction(Weapon weapon){
        int value = 0;
        for(int x = 0; x < weapon.weaponName.length(); x++){
            value+=(weapon.weaponName.charAt(x)-'a'+1)+weapon.cost+weapon.damage+weapon.weight+weapon.range;
        }
        return value%maxItems;
    }

    public void insert(Weapon item)
    {
        int pos = hashFunction(item);
        if (table[pos] == null)
            table[pos] = new LinkedList();
        table[pos].addFront(item);
        System.out.println(table[pos]);
        numItems++;
    }


    public void getPrintList(){
         for (LinkedList ll : table) {
             if (ll != null) {
                 System.out.println(ll.printList());
             }
         }
    }

}
