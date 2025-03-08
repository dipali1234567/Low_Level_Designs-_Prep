package org.example.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private final String id;
    private String content;
    private final String createdBy;
    private final LocalDateTime createdAt;

    public Comment(String content, String createdBy) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public String getId() { return id; }
    public String getContent() { return content; }
    public String getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Setter for content
    public void setContent(String content) { this.content = content; }
} 