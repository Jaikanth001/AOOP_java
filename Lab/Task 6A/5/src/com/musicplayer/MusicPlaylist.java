package com.musicplayer;

import java.util.LinkedList;

public class MusicPlaylist {
    private LinkedList<String> playlist = new LinkedList<>();

    public void addSong(String song) {
        playlist.add(song);
    }

    public void removeSong(String song) {
        playlist.remove(song);
    }

    public void moveSong(String song, int newPosition) {
        if (playlist.contains(song)) {
            playlist.remove(song);
            playlist.add(newPosition, song);
        } else {
            System.out.println("Song not found.");
        }
    }

    public void displayPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(i + ": " + playlist.get(i));
        }
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();

        // Example usage
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.moveSong("Song 1", 1);
        playlist.removeSong("Song 2");
        playlist.displayPlaylist();
    }
}
