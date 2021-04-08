package com.company;
    class Player
    {
        public String name;
        public int numItems;
        public double money;
        Backpack backpack;

        public Player(String n, double m)
        {
            name = n;
            money = m;
            numItems = 0;
            backpack = new Backpack(30);
        }

        public void buy(Weapon w)
        {
            System.out.println(w.weaponName+" bought...");
            backpack.insert(w);
            numItems++;
            System.out.println(numItems);
        }
        public void withdraw(double amt)
        {
            money = money - amt;
            if (money<=0){
                money = money + amt;
                System.out.println("You do not have enough money");
            }
        }

        public boolean inventoryFull()
        {
            return (numItems == 10) ;
        }

        public boolean noMoney()
        {
            return (money <= 0) ;
        }

        public void printCharacter()
        {
            System.out.println("\n");
            System.out.println(" Name:"+name+"\n Money:"+money);
            backpack.getPrintList();
        }


    }


