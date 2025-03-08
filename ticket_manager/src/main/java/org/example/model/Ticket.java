package org.example.model;

import org.example.enums.TicketStatus;
import org.example.enums.TicketType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Ticket {
    private final String id;
    private String title;
    private String description;
    private TicketStatus status;
    private final TicketType type;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final List<SubTask> subTasks;
    private final List<Comment> comments;

    public Ticket(String title, String description, TicketType type) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = TicketStatus.TO_DO;
        this.type = type;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.subTasks = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public abstract boolean canTransitionTo(TicketStatus newStatus);

    public void addSubTask(SubTask subTask) {
        this.subTasks.add(subTask);
    }

    public void removeSubTask(SubTask subTask) {
        this.subTasks.remove(subTask);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public boolean updateStatus(TicketStatus newStatus) {
        if (canTransitionTo(newStatus)) {
            if (hasIncompleteSubTasks() && isCompletionStatus(newStatus)) {
                System.out.println("Cannot transition to " + newStatus + " because there are incomplete subtasks.");
                return false;
            }
            this.status = newStatus;
            this.updatedAt = LocalDateTime.now();
            return true;
        }
        else {
            System.out.println("Cannot transition to " + newStatus + " because the status is not valid.");
        }
        return false;
    }

    private boolean hasIncompleteSubTasks() {
        return subTasks.stream().anyMatch(subTask -> !subTask.isCompleted());
    }

    protected boolean isCompletionStatus(TicketStatus status) {
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
    public TicketType getType() { return type; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public List<SubTask> getSubTasks() { return new ArrayList<>(subTasks); }
    public List<Comment> getComments() { return new ArrayList<>(comments); }
} 