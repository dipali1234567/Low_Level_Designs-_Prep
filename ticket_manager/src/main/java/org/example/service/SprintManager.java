package org.example.service;

import org.example.model.Sprint;
import org.example.model.StoryTicket;
import org.example.model.Ticket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SprintManager {
    private final Map<String, Sprint> sprints;
    private Sprint currentSprint;
    private final ReadWriteLock lock;

    public SprintManager() {
        this.sprints = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public Sprint createSprint(String name, LocalDateTime startDate, LocalDateTime endDate) {
        Sprint sprint = new Sprint(name, startDate, endDate);
        lock.writeLock().lock();
        try {
            sprints.put(sprint.getId(), sprint);
            if (currentSprint == null) {
                currentSprint = sprint;
            }
            return sprint;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean addStoryToSprint(String sprintId, Ticket ticket) {
        boolean result = false;
        if (!(ticket instanceof StoryTicket )) {
            return false;
        }
        else{
            System.out.println("Can't add this type of ticket to sprint");
        }

        lock.writeLock().lock();
        try {
            Sprint sprint = sprints.get(sprintId);
            if (sprint != null) {
                StoryTicket storyTicket = (StoryTicket) ticket;
                return sprint.addStory(storyTicket);
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean removeStoryFromSprint(String sprintId, Ticket ticket) {
        if (!(ticket instanceof StoryTicket)) {
            return false;
        }

        lock.writeLock().lock();
        try {
            Sprint sprint = sprints.get(sprintId);
            if (sprint != null) {
                StoryTicket storyTicket = (StoryTicket) ticket;
                return sprint.removeStory(storyTicket);
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Sprint> getAllSprints() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(sprints.values());
        } finally {
            lock.readLock().unlock();
        }
    }

    public Sprint getSprint(String sprintId) {
        lock.readLock().lock();
        try {
            return sprints.get(sprintId);
        } finally {
            lock.readLock().unlock();
        }
    }

    public Sprint getCurrentSprint() {
        lock.readLock().lock();
        try {
            return currentSprint;
        } finally {
            lock.readLock().unlock();
        }
    }
} 