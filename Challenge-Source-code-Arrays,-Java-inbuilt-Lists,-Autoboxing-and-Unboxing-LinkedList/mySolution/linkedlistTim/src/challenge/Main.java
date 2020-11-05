package challenge;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // PlayList
        LinkedList<Song> playlist = new LinkedList<Song>();

        // Songs
        Song s1 = new Song("love from the sky",3.23);
        Song s2 = new Song("Felling Happy",2.50);
        Song s3 = new Song("So sad",4.00);
        Song s4 = new Song("bad news",1.23);
        Song s5 = new Song("let's move on",5.23);


        ArrayList<Song> listAlbum_a1= new ArrayList<Song>();
        ArrayList<Song> listAlbum_a2= new ArrayList<Song>();
        listAlbum_a1.add(s1);
        listAlbum_a1.add(s2);

        listAlbum_a2.add(s3);
        listAlbum_a2.add(s4);

        // Albums
        Album a1 = new Album(listAlbum_a1);
        Album a2 = new Album(listAlbum_a2);

        // All Albums
        ArrayList<Album> list_of_albums = new ArrayList<Album>();
        list_of_albums.add(a1);
        list_of_albums.add(a2);

        // Add to the playlist

        add_to_playlist(playlist,list_of_albums,s1);
        add_to_playlist(playlist,list_of_albums,s3);
        add_to_playlist(playlist,list_of_albums,s5);
        add_to_playlist(playlist,list_of_albums,s3);
        add_to_playlist(playlist,list_of_albums,s4);
        add_to_playlist(playlist,list_of_albums,s2);

        printlist(playlist);

        play(playlist);


    }
    public static boolean check_song_in_albums(ArrayList alb, Song s){
        boolean check = false;
        for (int i = 0; i<alb.size();i++){
            Album random_alb = (Album) alb.get(i);
            if(random_alb.getListSongs().contains(s)){
                check = true;
            }
        }
        return check;
    }
    public static boolean add_to_playlist(LinkedList lis, ArrayList<Album> list_of_albums, Song s){
        if(check_song_in_albums(list_of_albums,s)){
            if(lis.contains(s)){
                System.out.println("the song is already in the playlist");
                return false;
            }
            else{
                lis.add(s);
                System.out.println("The song is added");
                return true;
            }
        }
        System.out.println("The song does not exist in any album");
        return false;
    }
    public static void play(LinkedList lis){
        ListIterator<Song> i = lis.listIterator();
        boolean quit = false;
        boolean goingForward = false;
        if(lis.isEmpty()){
            System.out.println("The playlist is empty");
        }
        else{
            printMenu();
        }

        Scanner sc = new Scanner(System.in);
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0:
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
                        System.out.println("next music "+ i.next());
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
                        System.out.println("previous music "+ i.previous());

                    }
                    else{
                        System.out.println("We are in the first element in the list");
                    }

                    break;
                case 3:
                    if(goingForward){
                        if(i.hasPrevious()){
                            System.out.println("HERE");
                            //int p = i.nextIndex() - 1;
                            System.out.println("current music "+ i.previous().toString());
                            //System.out.println("current music " + lis.get(p));
                            //i.previous();
                            goingForward = false;
                        }

                        else{
                            System.out.println("We are at the start of the playlist");
                        }
                    }
                    else{
                        if(i.hasNext()){
                            System.out.println("Here2");
                            System.out.println("current music "+ i.next().toString());
                            //i.next();
                            goingForward =true;
                        }
                        else{
                            System.out.println("We have reached the end of the list");
                        }
                    }

                    /*else{
                        System.out.println("Here2");
                        System.out.println("current music "+ i.next());
                        //i.next();
                        //goingForward =true;

                    }
                    i.remove();*/

                    break;
                case 4:
                    printlist(lis);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:

                    i.remove();
                    System.out.println("The current song is deleted");

            }
        }

    }
    public static void printlist(LinkedList lis){
        Iterator<Song> i = lis.iterator();
        while(i.hasNext()){
            System.out.println(i.next().toString());
        }
    }
    public static void printMenu(){
        System.out.println("Your Menu : \n");
        System.out.println("0 - to quit \n" +
                "1 - next music \n"+
                "2 - previous music \n" +
                "3 - play the current music \n" +
                "4 - list all music in the playlist \n" +
                "5 - print the menu\n" +
                "6 - delete the current song from the playlist");
    }


}
