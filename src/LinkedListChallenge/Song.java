package LinkedListChallenge;

import java.util.LinkedList;

public class Song implements ISong {
    private String title;
    private double durationOfSong;

    public Song(String title, double durationOfSong) {
        this.title = title;
        this.durationOfSong = durationOfSong;
    }

    public String getTitle() {
        return title;
    }

    public double getDurationOfSong() {
        return durationOfSong;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDurationOfSong(double durationOfSong) {
        this.durationOfSong = durationOfSong;
    }

    @Override
    public String toString() {
        return "Song: "  + title +
                " Duration: " + durationOfSong;
    }
}
