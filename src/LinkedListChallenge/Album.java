package LinkedListChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private final ArrayList<LinkedList<Song>> ALBUM_LIST;
    LinkedList<Song> SONG_LINKED_LIST;

    public Album(String albumName) {
        this.albumName = albumName;
        this.ALBUM_LIST = new ArrayList<>();
        this.SONG_LINKED_LIST = new LinkedList<>();
        this.ALBUM_LIST.add(SONG_LINKED_LIST);
    }

    public String getAlbumName() {
        return albumName;
    }

    class songList {

        public songList(){

        }

        public Song getSong(String songName) {
            int position = findSong(songName);
            if (position < 0) {
                System.out.println("Song is not in album");
            }


            return SONG_LINKED_LIST.get(position);
        }

        public boolean addSong(Song song) {
            int position = findSong(song);
            if (position > 0) {
                System.out.println("Song is already in album");
                return false;
            }
            SONG_LINKED_LIST.add(song);
            System.out.println("Song has been added");
            return true;
        }

        public int findSong(String songName) {
            for (int i = 0; i < SONG_LINKED_LIST.size(); i++) {
                if (SONG_LINKED_LIST.get(i).getTitle().equalsIgnoreCase(songName)) {
                    return i;
                }
            }

            return -1;
        }

        public int findSong(Song song) {
            return SONG_LINKED_LIST.indexOf(song);
        }


        public void print() {


        }
    }

    boolean addSong(Song song1) {
        Album.songList song = new songList();
        return song.addSong(song1);
    }

    int findSong(String songName) {
        songList song = new songList();
        return song.findSong(songName);
    }

    Song getSong(String songName) {
        songList song = new songList();
        return song.getSong(songName);
    }

    public void printSongsInAlbum() {
        for (int i = 0; i < this.ALBUM_LIST.size(); i++) {
            System.out.println(ALBUM_LIST.toString());
        }
    }
}
