//John Michael De Guzman 101248107
//Gabriel Silva 101245036
//Ruzzel Orejola 1013474777
package com.company;

public class Backpack {

    private LinkedList[] table;
    int maxItems;
    int numItems;
    double currWeight;
    double maxWeight;

    public Backpack(){
        maxItems = 30;
        maxWeight = 90;
        currWeight = 0;
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
        if(currWeight + item.weight <= maxWeight ) {
            if(numItems <= maxItems) {
                int pos = hashFunction(item);
                if (table[pos] == null)
                    table[pos] = new LinkedList();
                table[pos].addFront(item);
                currWeight += item.weight;
                numItems++;
            }
            else{
                System.out.println("The bag is full....");
            }
        }
        else{
            System.out.println("The bag too heavy....");
        }
    }


    public void getPrintList(){
         for (LinkedList ll : table) {
             if (ll != null) {
                 System.out.println(ll.printList());
             }
         }
    }

}
