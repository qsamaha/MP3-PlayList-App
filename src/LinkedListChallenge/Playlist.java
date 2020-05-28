package LinkedListChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private String playlistName;
    private ArrayList<Album> albumList;
    private LinkedList<Song> songPlayList;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.albumList = new ArrayList<>();
        this.songPlayList = new LinkedList<>();
    }

    public LinkedList<Song> getSongPlayList() {
        return songPlayList;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public boolean addAlbum(String albumName) {
        int position = findAlbum(albumName);
        if (position >= 0) {
            System.out.println("Album is already in playlist");
            return false;
        } else {

            Album album = new Album(albumName);
            this.albumList.add(album);
            return true;
        }
    }

    public boolean addSongsToAlbum(String albumName, String songName, double songDuration) {
        int position = findAlbum(albumName);
        Song newSong = new Song(songName, songDuration);
        if (position < 0) {
            System.out.println("Album not found");
            return false;
        } return this.albumList.get(position).addSong(newSong);

    }

    public boolean addSongsToPlayList(String albumName, String songName) {
        int albumPosition = findAlbum(albumName);

        if (albumPosition < 0) {
            System.out.println("Album Not found");
            return false;
        }

        int songPosition = this.albumList.get(albumPosition).findSong(songName);
        if (songPosition < 0) {
            System.out.println("Song not found");
            return false;
        } else {
            Song song = this.albumList.get(albumPosition).getSong(songName);
            this.songPlayList.add(song);
            return true;
        }
    }

    public boolean deleteSongsFromPlayList(String albumName, String songName) {
        int albumPosition = findAlbum(albumName);

        if (albumPosition < 0) {
            System.out.println("Album Not found");
            return false;
        }

        int songPosition = this.albumList.get(albumPosition).findSong(songName);
        if (songPosition < 0) {
            System.out.println("Song not found");
            return false;
        } else {
            Song song = this.albumList.get(albumPosition).getSong(songName);
            this.songPlayList.remove(song);
            return true;
        }
    }

    public int findAlbum(String albumName) {
        for (int i = 0; i < albumList.size(); i++) {
            if (this.albumList.get(i).getAlbumName().equalsIgnoreCase(albumName)) {
                return i;
            }
        }

        return -1;
    }

    public int findAlbum(Album album) {
        return albumList.indexOf(album);
    }

    public void printAlbums() {
        for (Album album : albumList) {
            System.out.println("Album: " + albumList.get(findAlbum(album)).getAlbumName());
            this.albumList.get(findAlbum(album)).printSongsInAlbum();
        }
    }

    public void printPlaylist() {
        for (Song song : songPlayList) {
            System.out.println("Song Name: " + song.getTitle() + " | Song Duration: " + song.getDurationOfSong());
        }
    }
}
