package cz.activate.musicalapp;

/**
 * Created by Michaela on 5/18/2018.
 */

public class Song {
    private String name;
    private String artist;

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getSongName() {
        return name;
    }
    public String getSongArtist() {
        return artist;
    }
}
