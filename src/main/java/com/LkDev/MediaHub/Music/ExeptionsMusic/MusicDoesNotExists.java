package com.LkDev.MediaHub.Music.ExeptionsMusic;

public class MusicDoesNotExists extends RuntimeException {
    public MusicDoesNotExists(String message) {
        super(message);
    }
}
