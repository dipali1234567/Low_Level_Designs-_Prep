package org.example.model;

import org.example.enums.TicketStatus;
import org.example.enums.TicketType;
import java.util.ArrayList;
import java.util.List;

public class OnCallTicket extends Ticket {
    public OnCallTicket(String title, String description) {
        super(title, description, TicketType.ON_CALL);
    }

    @Override
    public boolean canTransitionTo(TicketStatus newStatus) {
        TicketStatus currentStatus = getStatus();
        TicketStatus allowedStatus = newStatus;
        boolean result = false;
        switch (currentStatus) {
            case TO_DO:
                result = (newStatus == TicketStatus.OPEN);
                break;
            case OPEN : result = (newStatus == TicketStatus.IN_PROGRESS); break;
            case IN_PROGRESS : result = (newStatus == TicketStatus.RESOLVED);
                                break;
            default : result = false;
        };
        return result;
    }
} 