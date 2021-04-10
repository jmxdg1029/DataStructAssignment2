//John Michael De Guzman 101248107
//Gabriel Silva 101245036
//Ruzzel Orejola 1013474777
package com.company;

public class LinkedList{

    private Node head;

    public LinkedList(){
        head = null;
    }

    public void addFront(Weapon item){
        Node newNode = new Node(item);
        newNode.next=head;
        head=newNode;
    }


    public String printList(){
        String s="Slot: ";
        Node curr= head;
        while (curr!=null){
            s+=curr.data.weaponName+" ";
            curr=curr.next;
        }
        return s;
    }
}
