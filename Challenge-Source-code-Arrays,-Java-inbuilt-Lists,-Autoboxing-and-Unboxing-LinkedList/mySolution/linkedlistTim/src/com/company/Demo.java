package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*
ListIterator # Iterator
previous function that helps us to repoint in the previous element

 */
public class Demo {
    public static void main(String[] args) {
        /*LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Ahfir");
        placesToVisit.add("Rabat");
        placesToVisit.add("Saidia");
        placesToVisit.add("Marrakech");
        placesToVisit.add("Tanger");
        placesToVisit.add("Oujda");
        printlist(placesToVisit);
        placesToVisit.add(1,"Berkane");
        System.out.println("After adding new element");
        printlist(placesToVisit);
        placesToVisit.remove(4);
        System.out.println("After removing the elemeent in the index 4");
        printlist(placesToVisit);*/

        LinkedList<String> places = new LinkedList<String>();
        addInOrder(places,"Ahfir");
        addInOrder(places,"Rabat");
        addInOrder(places,"Berkane");
        printlist(places);
        addInOrder(places,"Berkane");
//        printlist(places);
        visit(places);
    }
    public static void printlist(LinkedList<String> linkedlist){
        Iterator<String> i = linkedlist.iterator();
        while(i.hasNext()){
            System.out.println(i + " : " + i.next());
        }
    }
    public static boolean addInOrder(LinkedList<String> linkedlist, String newCity){
        ListIterator<String> i = linkedlist.listIterator();
        while(i.hasNext()){
            int x = i.next().compareTo(newCity);
            if (x == 0){
                System.out.println("The element exists already");
                return false;
            }
            else if(x>0){
                i.previous();
                i.add(newCity);
                return true;
            }
            else {

            }
        }
        i.add(newCity);
        return true;
    }
    public static void visit(LinkedList cities){
        Scanner sc = new Scanner(System.in);
        ListIterator<String> i = cities.listIterator();
        boolean goingForward = false;
        boolean quit = false;
        if (cities.isEmpty()){
            System.out.println("No city to visit");
        }
        else{
            printMenu();
        }


        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0 :
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(i.hasNext()){
                            i.next();
                        }
                        goingForward = true;
                    }
                    if(i.hasNext()){
                        System.out.println("Going to "+ i.next());
                    }
                    else{
                        System.out.println("We are in the end of the list");
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(i.hasPrevious()){
                            i.previous();
                        }
                        goingForward = false;
                    }
                    if(i.hasPrevious()){
                        System.out.println("Going to "+ i.previous());
                    }
                    else{
                        System.out.println("We are in the first element in the list");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("Your Menu\n");
        System.out.println("0 - Quit\n" +
                           "1 - go to next city\n"+
                           "2 - go to previous city\n"+
                           "3 - print menu");
    }
}
