package org.example.model;

import org.example.enums.TicketStatus;
import org.example.enums.TicketType;

public class StoryTicket extends Ticket {
    private boolean isInSprint;

    public StoryTicket(String title, String description) {
        super(title, description, TicketType.STORY);
        this.isInSprint = false;
    }

    @Override
    public boolean canTransitionTo(TicketStatus newStatus) {
        TicketStatus currentStatus = getStatus();
        boolean result = false;
        
        switch (currentStatus) {
            case TO_DO:
                result = (newStatus == TicketStatus.OPEN);
                break;
            case OPEN:
                result = (newStatus == TicketStatus.IN_PROGRESS);
                break;
            case IN_PROGRESS:
                result = (newStatus == TicketStatus.TESTING);
                break;
            case TESTING:
                result = (newStatus == TicketStatus.IN_REVIEW);
                break;
            case IN_REVIEW:
                result = (newStatus == TicketStatus.DEPLOYED);
                break;
            default:
                result = false;
        }
        return result;
    }

    public boolean isInSprint() {
        return isInSprint;
    }

    public void setInSprint(boolean inSprint) {
        isInSprint = inSprint;
    }
}