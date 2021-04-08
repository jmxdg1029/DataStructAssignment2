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
        String s="List: ";
        Node curr= head;
        while (curr!=null){
            s+=curr.data.weaponName+" ";
            curr=curr.next;
        }
        return s;
    }
}
