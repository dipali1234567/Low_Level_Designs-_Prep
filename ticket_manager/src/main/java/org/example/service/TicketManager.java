package org.example.service;

import org.example.enums.TicketStatus;
import org.example.enums.TicketType;
import org.example.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.example.enums.TicketType.*;

public class TicketManager {
    private final Map<String, Ticket> tickets;
    private final Map<String, Sprint> sprints;
    private Sprint currentSprint;
    private final ReadWriteLock lock;

    public TicketManager() {
        this.tickets = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
        this.sprints = new HashMap<>();
    }

    public Ticket createTicket(String title, String description, TicketType type) {
        Ticket ticket = null;

        switch (type) {
            case STORY:
                ticket = new StoryTicket(title, description);
                break;
            case EPIC:
                ticket = new EpicTicket(title, description);
                break;
            case ON_CALL:
                ticket = new OnCallTicket(title, description);
                break;
        }

        lock.writeLock().lock();
        try {
            tickets.put(ticket.getId(), ticket);
            return ticket;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public synchronized boolean updateTicketStatus(String ticketId, TicketStatus newStatus) {
        lock.writeLock().lock();
        try {
            Ticket ticket = tickets.get(ticketId);
            if (ticket != null) {
                return ticket.updateStatus(newStatus);
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public synchronized SubTask addSubTask(String ticketId, String title, String description) {
        lock.writeLock().lock();
        try {
            Ticket ticket = tickets.get(ticketId);
            if (ticket != null) {
                SubTask subTask = new SubTask(title, description);
                ticket.addSubTask(subTask);
                return subTask;
            }
            return null;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public synchronized boolean removeSubTask(String ticketId, SubTask subTask) {
        lock.writeLock().lock();
        try {
            Ticket ticket = tickets.get(ticketId);
            if (ticket != null) {
                ticket.removeSubTask(subTask);
                return true;
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Comment addComment(String ticketId, String content, String authorId) {
        lock.writeLock().lock();
        try {
            Ticket ticket = tickets.get(ticketId);
            if (ticket != null) {
                Comment comment = new Comment(content, authorId);
                ticket.addComment(comment);
                return comment;
            }
            return null;
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Getters
    public List<Ticket> getAllTickets() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(tickets.values());
        } finally {
            lock.readLock().unlock();
        }
    }

    public Ticket getTicket(String ticketId) {
        lock.readLock().lock();
        try {
            return tickets.get(ticketId);
        } finally {
            lock.readLock().unlock();
        }
    }
} 