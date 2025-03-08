package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sprint {
    private final String id;
    private String name;
    private final LocalDateTime startDate;
    private LocalDateTime endDate;
    private final List<StoryTicket> stories;

    public Sprint(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stories = new ArrayList<>();
    }

    public boolean addStory(StoryTicket story) {
        if (!stories.contains(story)) {
            stories.add(story);
            story.setInSprint(true);
            return true;
        }
        return false;
    }

    public boolean removeStory(StoryTicket story) {
        if (stories.remove(story)) {
            story.setInSprint(false);
            return true;
        }
        return false;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    public List<StoryTicket> getStories() { return new ArrayList<>(stories); }
} 