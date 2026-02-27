package com.taller3.export.model;

import java.time.LocalDateTime;

/**
 * Document model with metadata.
 */
public record Document(
        String title,
        String content,
        String author,
        LocalDateTime createdAt
) {
    public Document(String title, String content, String author) {
        this(title, content, author, LocalDateTime.now());
    }
}
