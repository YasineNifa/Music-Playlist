package challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Album {
    private ArrayList<Song> listSongs;
    public Album(ArrayList<Song> listSongs){
        this.listSongs = listSongs;
    }
    public ArrayList<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(ArrayList<Song> listSongs) {
        this.listSongs = listSongs;
    }
    public void sortAlbum(ArrayList lis){
        Collections.sort(lis);
       // ListIterator<Song> i = listSongs.listIterator();


    }
}
