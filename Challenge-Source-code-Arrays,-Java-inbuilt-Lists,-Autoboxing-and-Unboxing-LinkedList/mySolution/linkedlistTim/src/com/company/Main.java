package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Customer customer = new Customer("Yassine", 35.64);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(22.90);
        System.out.println(customer.getName() + " has a balance of " + customer.getBalance());*/


        ArrayList<Integer> newlist = new ArrayList<Integer>();
        newlist.add(1);
        newlist.add(3);
        newlist.add(4);
        for (int i = 0; i< newlist.size();i++){
            System.out.println(i + " : " + newlist.get(i));
        }
        newlist.add(1,2);
        System.out.println("After adding new element");
        for (int i = 0; i< newlist.size();i++){
            System.out.println(i + " : " + newlist.get(i));
        }
    }
}
