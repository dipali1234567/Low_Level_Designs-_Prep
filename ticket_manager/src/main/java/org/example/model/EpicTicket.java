package org.example.model;

import org.example.enums.TicketStatus;
import org.example.enums.TicketType;
import java.util.ArrayList;
import java.util.List;

public class EpicTicket extends Ticket {

    public EpicTicket(String title, String description) {
        super(title, description, TicketType.EPIC);
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
            case OPEN : result = (allowedStatus == TicketStatus.IN_PROGRESS);
                        break;
            case IN_PROGRESS : result = (allowedStatus == TicketStatus.COMPLETED); break;
            default : result = false;
        };
        return result;
    }
} 