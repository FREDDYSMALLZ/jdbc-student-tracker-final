package com.luv2code.jsf.jdbc;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Song {
    private int id;
    private String albumTitle;
    private String albumArtist;
    private int numberOfSongs;
    private String songTitle;
    private int songNumber;

    public Song() {
    }

    public Song(int id, String albumTitle, String albumArtist,
                int numberOfSongs, String songTitle, int songNumber) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.albumArtist = albumArtist;
        this.numberOfSongs = numberOfSongs;
        this.songTitle = songTitle;
        this.songNumber = songNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public int getSongNumber() {
        return songNumber;
    }

    public void setSongNumber(int songNumber) {
        this.songNumber = songNumber;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + ", albumTitle=" + albumTitle + ", albumArtist="
                + albumArtist + ", numberOfSongs=" + numberOfSongs + ", songTitle="
                + songTitle + ", songNumber=" + songNumber + " ]";
    }
}


