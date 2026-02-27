package com.taller3.export;

/**
 * Thrown when export validation fails.
 */
public class ExportException extends RuntimeException {
    public ExportException(String message) {
        super(message);
    }
}
