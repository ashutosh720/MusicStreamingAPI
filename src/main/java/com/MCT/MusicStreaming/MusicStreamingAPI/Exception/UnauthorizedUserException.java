package com.MCT.MusicStreaming.MusicStreamingAPI.Exception;


public class UnauthorizedUserException extends RuntimeException {

    public UnauthorizedUserException(String message) {
        super(message);
    }
}
