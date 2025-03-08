package org.example;

import org.example.enums.TicketStatus;
import org.example.enums.TicketType;
import org.example.model.Sprint;
import org.example.model.Ticket;
import org.example.service.SprintManager;
import org.example.service.TicketManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Welcome to the ticket manager!");

        // Initialize managers
        TicketManager ticketManager = new TicketManager();
        SprintManager sprintManager = new SprintManager();

        // Create tickets
        Ticket loginStory = ticketManager.createTicket(
            "Implement login feature",
            "Create a secure login system for ticket management system",
            TicketType.STORY
        );

        Ticket loginStory2 = ticketManager.createTicket(
                "Implement login feature",
                "Create a secure login system for ticket management system",
                TicketType.STORY
        );


        Ticket authEpic = ticketManager.createTicket(
            "User authentication",
            "This is epic for user authentication",
            TicketType.EPIC
        );

        Ticket productionBug = ticketManager.createTicket(
            "Fix production bug",
            " database resulting in production bug",
            TicketType.ON_CALL
        );
        // Create Ticket Completed

        System.out.println("let's create Sprint");

        Sprint sprint = sprintManager.createSprint(
                "Sprint 1",
                LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(2)
        );
        System.out.println("created Sprint with id: " + sprint.getId());
        System.out.println("Now we will try to add tickets to sprint");
        // Create a sprint

        // Add story to sprint
        sprintManager.addStoryToSprint(sprint.getId(), loginStory);
        sprintManager.addStoryToSprint(sprint.getId(), authEpic);
        sprintManager.addStoryToSprint(sprint.getId(), productionBug);
        sprintManager.addStoryToSprint(sprint.getId(), loginStory2);
        // Add subtasks to tickets
        ticketManager.addSubTask(
            loginStory.getId(),
            "Design login UI",
            "Design good UI for login"
        );

        ticketManager.addSubTask(
                loginStory.getId(),
                "Develop backend service",
                "Develop backend service login authentication"
        );

        ticketManager.addSubTask(
            authEpic.getId(),
            "Design authentication flow",
            "Create authentication flow diagram"
        );

        // Update ticket statuses
        ticketManager.updateTicketStatus(loginStory.getId(), TicketStatus.OPEN);
        ticketManager.updateTicketStatus(authEpic.getId(), TicketStatus.OPEN);
        ticketManager.updateTicketStatus(productionBug.getId(), TicketStatus.OPEN);
        ticketManager.updateTicketStatus(productionBug.getId(), TicketStatus.RESOLVED);
        // Add comments
        ticketManager.addComment(
            loginStory.getId(),
            "UI design completed, ready for review",
            "user123"
        );

        // Print current sprint details
        Sprint currentSprint = sprintManager.getCurrentSprint();
        System.out.println("Current Sprint: " + currentSprint.getName());
        System.out.println("Stories in Sprint:");
        for (Ticket story : currentSprint.getStories()) {
            System.out.println("- " + story.getTitle() + " (Status: " + story.getStatus() + ")");
        }

        System.out.println("Removing stories from Sprint: "+loginStory2.getId());
        sprintManager.removeStoryFromSprint(sprint.getId(), loginStory2);
        // Print all tickets

        System.out.println("Current Sprint: " + currentSprint.getName());
        System.out.println("Stories in Sprint after deletion :");
        for (Ticket story : currentSprint.getStories()) {
            System.out.println("- " + story.getTitle() + " (Status: " + story.getStatus() + ")");
        }

        System.out.println("\nAll Tickets:");
        for (Ticket ticket : ticketManager.getAllTickets()) {
            System.out.println("- " + ticket.getTitle() + " (Type: " + ticket.getType() + ", Status: " + ticket.getStatus() + ")");
            System.out.println("-- comments - " + ticket.getComments());
            System.out.println("-- subtasks" + ticket.getSubTasks());
        }


    }
}