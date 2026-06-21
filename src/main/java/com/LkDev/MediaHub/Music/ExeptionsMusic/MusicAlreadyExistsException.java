package com.LkDev.MediaHub.Music.ExeptionsMusic;

public class MusicAlreadyExistsException extends RuntimeException {
    public MusicAlreadyExistsException(String message) {
        super(message);
    }
}
