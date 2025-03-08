package org.example.model;

import org.example.enums.TicketStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class SubTask {
    private final String id;
    private String title;
    private String description;
    private TicketStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SubTask(String title, String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = TicketStatus.OPEN;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public boolean updateStatus(TicketStatus newStatus) {
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
        return true;
    }

    public boolean isCompleted() {
        return status == TicketStatus.DEPLOYED || 
               status == TicketStatus.COMPLETED || 
               status == TicketStatus.RESOLVED;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TicketStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
} 