package LinkedListChallenge;

import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner (System.in);
    private static Playlist newPlaylist = new Playlist("Q's Playlist");
    public static void main(String[] args) {
        appStartingUp();
        printInstructions();
        boolean quit = true;
        boolean goingForward = true;
        ListIterator<Song> listIterator = newPlaylist.getSongPlayList().listIterator();

        while(quit){
            System.out.println("Enter Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    createAnAlbum();
                    break;
                case 2:
                    addSongToAlbum();
                    break;
                case 3:
                    addSongToPlaylist();
                    break;
                case 4:
                    deleteSongFromPlaylist();
                    break;
                case 5:
                    printPlaylist();
                    break;
                case 6:
                    printAlbums();
                    break;
                case 7:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                         listIterator.next();
                    }else{
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 8:
                    if(goingForward){
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            goingForward = false;
                        }
                    }
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                    }else{
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 9:
                    quit = false;
                    break;
                default:
                    System.out.println("That is not a valid option, Please Try Again");
            }
        }

    }

    public static void appStartingUp(){
        System.out.println("Your iPod is now starting up>>>>>>>>>>>>>>>>");
    }

    public static void printInstructions(){
        System.out.println("0 -> Print this list of Instructions");
        System.out.println("1 -> Create an Album");
        System.out.println("2 -> Add song to Album");
        System.out.println("3 -> Create a Playlist");
        System.out.println("4 -> Delete song from your Playlist");
        System.out.println("5 -> Print songs in Playlist");
        System.out.println("6 -> Print Albums and Songs");
        System.out.println("7 -> Skip song");
        System.out.println("8 -> Play previous song");
        System.out.println("9 -> Quit Application");
    }

    public static void createAnAlbum(){
        System.out.println("Enter name of album you would like to add to your iPod:");
        String userChoice = scan.nextLine();
        if(newPlaylist.addAlbum(userChoice)){
            System.out.println("Album has been added");
        }else{
            System.out.println("Album could not be added");
        }
    }

    public static void addSongToAlbum(){
        System.out.println("Enter name of album you would like to add a song to: ");
        String userAlbum = scan.nextLine();
        if(newPlaylist.findAlbum(userAlbum) < 0){
            System.out.println("Sorry album has not been added");
            return;
        }
        System.out.println("Enter song name: ");
        String userSong = scan.nextLine();
        System.out.println("Enter song duration: ");
        double userDuration = scan.nextDouble();
        scan.nextLine();
        if(newPlaylist.addSongsToAlbum(userAlbum, userSong, userDuration)){
            System.out.println("Song has been added to album");
        }else{
            System.out.println("Song could not be added");
        }
    }

    public static void addSongToPlaylist(){
        System.out.println("Enter album that contains song you would like to add to your playlist: ");
        String userAlbum = scan.nextLine();
        if(newPlaylist.findAlbum(userAlbum) < 0){
            System.out.println("Album could not be found.");
            return;
        }
        System.out.println("Enter song name: ");
        String songName = scan.nextLine();

        if(newPlaylist.addSongsToPlayList(userAlbum, songName)){
            System.out.println("Song has been added to playlist");
        }else{
            System.out.println("Song could not be added to playlist");
        }
    }

    public static void deleteSongFromPlaylist(){
        System.out.println("Enter album you would like to delete song from: ");
        String userAlbum = scan.nextLine();
        if(newPlaylist.findAlbum(userAlbum) < 0){
            System.out.println("Album could not be found.");
            return;
        }
        System.out.println("Enter song name: ");
        String songName = scan.nextLine();

        if(newPlaylist.deleteSongsFromPlayList(userAlbum, songName)){
            System.out.println("Song has been deleted from playlist");
        }else{
            System.out.println("Song could not be deleted from playlist");
        }
    }

    public static void printAlbums(){
        newPlaylist.printAlbums();
    }
    public static void printPlaylist(){
        System.out.println(newPlaylist.getPlaylistName());
        newPlaylist.printPlaylist();
    }

}
