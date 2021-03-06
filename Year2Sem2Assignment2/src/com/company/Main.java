//John Michael De Guzman 101248107
//Gabriel Silva 101245036
//Ruzzel Orejola 1013474777

package com.company;

import java.util.Scanner;

public class Main {

    public static int getInteger(Scanner sc, String message){
        System.out.print(message);
        while (!sc.hasNextInt())
        {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextInt();
    }

    public static double getDouble(Scanner sc,String message){
        System.out.print(message);
        while (!sc.hasNextDouble())
        {
            sc.nextLine(); //clear the invalid input ..
            System.out.print(message);

        }
        return sc.nextDouble();
    }



    public static void showMenu(ArrayManager h,Player p,Scanner sc)
    {
        int choice;
        System.out.println("Please chose the following");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1) Add Items to the show");
        System.out.println("2) Delete Items from the show");
        System.out.println("3) Buy from the Shop");
        System.out.println("4) View backpack");
        System.out.println("5) View Player");
        System.out.println("6) Exit");
        choice = getInteger(sc,"Please Chose the following: ");
        switch (choice){
            case 1:
                addWeapons(h,sc);
                showMenu(h, p, sc);
                break;
            case 2:
                removeWeapon(h,sc);
                showMenu(h,p,sc);
                break;
            case 3:
                showRoom(h,p,sc);
                showMenu(h, p,sc);
                break;
            case 4:
                viewBackpack(p,sc);
                showMenu(h, p, sc);
                break;
            case 5:
                p.printCharacter();
                showMenu(h, p, sc);
            case 6:
                break;
        }

    }

    public static void viewBackpack(Player p,Scanner sc)
    {
        System.out.println("***********WELCOME TO " + p.name + "'s Backpack*********");
        p.printBackpack();
    }



    public static void addWeapons(ArrayManager h,Scanner sc)
    {
        System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
        String weaponName; int weaponRange; int weaponDamage; double weaponWeight; double weaponCost;
        int quantity;
        System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
        weaponName=sc.next();
        while (weaponName.compareTo("end") != 0)
        {
            if(h.nameCheck(weaponName) == -1) {
                weaponRange = getInteger(sc, "Please enter the Range of the Weapon (0-10):");
                weaponDamage = getInteger(sc, "Please enter the Damage of the Weapon:");
                weaponWeight = getDouble(sc, "Please enter the Weight of the Weapon (in pounds):");
                weaponCost = getDouble(sc, "Please enter the Cost of the Weapon:");
                Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
                quantity = getInteger(sc, "Please enter the quantity in stock:");
                h.put(w, quantity);
                System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
                weaponName = sc.next();
            }else{
                System.out.println();
                System.out.println("This name is already in the Shop.");
                quantity = getInteger(sc,("Please enter the amount you would like to add in stock:"));
                h.addStock(weaponName,quantity);
                System.out.println("Thank You!!");
                System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
                weaponName = sc.next();
            }
        }
    }


    public static void showRemoveMenu(ArrayManager ht){

        System.out.println();
        System.out.println("***********DELETE A WEAPON*********");
        System.out.print("Please enter the Name of the Weapon ('end' to quit):");
    }


    public static void removeWeapon(ArrayManager ht, Scanner sc)
    {
        String weaponName;
        showRemoveMenu(ht);
        weaponName = sc.next();
        while(weaponName.compareTo("end") != 0)
        {
            if (ht.removeItem(weaponName)){
                System.out.println();
                System.out.println("SUCCESS");
                System.out.println("Item has been deleted");
            }else{
                System.out.println();
                System.out.println("---WARNING---");
                System.out.println("That item is not in the Shop...");
                System.out.println("---WARNING---");
            };
            showRemoveMenu(ht);
            weaponName = sc.next();
        }
        System.out.println();
    }



    public static void showRoomMenu(ArrayManager ht,Player p){
        System.out.println("WELCOME TO THE SHOWROOM!!!!");
        ht.printTable();
        System.out.println("You have "+p.money+" money.");
        System.out.println("Please select a weapon to buy('end' to quit):");
    }

    public static void showRoom(ArrayManager ht, Player p,Scanner sc) {
        String choice;
        showRoomMenu(ht, p);
        choice = sc.next();
        while (choice.compareTo("end") != 0 && !p.inventoryFull()) {
            ShopItem si = ht.get(choice);
            if (si != null && si.numberInStock > 0) {
                if (p.withdraw(si.item.cost) != false) {
                    p.buy(si.item);
                    si.numberInStock--;
                } else {
                    System.out.println("Not enough Money");
                }
            } else {
                System.out.println(" ** " + choice + " not found!! **");
            }
            showRoomMenu(ht, p);
            choice = sc.next();
        }
        System.out.println("");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String pname;
        System.out.println("Please enter Player name:");
        pname=sc.next();
        Player pl= new Player(pname,45);
        ArrayManager ht= new ArrayManager(80);
        showMenu(ht,pl,sc);
    }
}
