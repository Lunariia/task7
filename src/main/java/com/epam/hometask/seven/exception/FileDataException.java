package com.epam.hometask.seven.exception;

public class FileDataException extends Exception {

    public FileDataException(String message, Throwable cause, String fileLocation) {
        super(message, cause);
        System.out.println("Location: " + fileLocation);
    }

}
