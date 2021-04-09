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
            backpack = new Backpack();
        }

        public void buy(Weapon w)
        {

            backpack.insert(w);
            System.out.println(w.weaponName+" bought...");
            numItems++;
            System.out.println(numItems);
        }
        public boolean withdraw(double amt)
        {
            money = money - amt;
            if (money<=0){
                money = money + amt;
                return false;
            }
            return true;
        }

        public boolean inventoryFull()
        {
            return (numItems == 10) ;
        }

        public boolean noMoney()
        {
            return (money < 0) ;
        }

        public void printCharacter()
        {
            System.out.println("\n");
            System.out.println(" Name:"+name+"\n Money:"+money);
            backpack.getPrintList();
        }

        public void printBackpack(){
            backpack.getPrintList();
        }

    }


