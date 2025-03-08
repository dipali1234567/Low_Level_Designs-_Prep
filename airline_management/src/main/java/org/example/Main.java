package org.example;

import org.example.dto.Airline;
import org.example.dto.Flight;
import org.example.dto.Seat;
import org.example.dto.User;
import org.example.enums.FareType;
import org.example.service.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        Commands(Test cases):
//        AddUser(userld, name, funds)
//        ADDUSER u1 Vinit 5000
//        ADDUSER u2 Neha 1500
//        SearchFlightfrom, to, departDate, paxCount)
//        SEARCHFLIGHT DEL BLR 2 1
//        SEARCHFLIGHT DEL BLR 22
//        SEARCHFLIGHT DEL HYD 2 22
//        Book flight(userld, from, to, flightNumber, airline, departDate, fare Type, list< seat>)
//        BOOK u1, DEL, BOM, 111, 6e, 2, F1, 10a, 11c, 20b
//        BOOK u1, DEL, BOM, 211, 6e, 2, F2, 10a, 11c, 20b
//        BOOK u2, DEL, BOM, 141, 6e, 2, F4, 32e
//        SearchFlight(from, to, departDate, paxCount, preferredAirline, sortBy, SortType)
//        SEARCHFLIGHT DEL, BLR, 2, 1, AI, PRICE, DESC

        System.out.println("Welcome to the Airline Booking System!");
        UserManager userManager = new UserManagerImpl();
        FlightManager flightManager = new FlightManagerServiceImpl();
        AirlineManager airlineManager = new AirLineManagerServiceImpl();


        Airline airline1 = new Airline("6E");
        Airline airline2 = new Airline("SJ");
        Airline airline3 = new Airline("UK");
        Airline airline4 = new Airline("QP");
        airlineManager.addAirline(airline1);
        airlineManager.addAirline(airline2);
        airlineManager.addAirline(airline3);
        airlineManager.addAirline(airline4);

        Flight f1 = new Flight(123,"F1",airline1,"DEL","BLR",3,2,10,11,2000, FareType.F1, List.of(new Seat("1b"),new Seat("2c"),new Seat("4e")));
        Flight f2 = new Flight(156,"F2",airline1,"DEL","BLR",1,2,14,15,4000, FareType.F2, List.of(new Seat("4e")));
        Flight f3 = new Flight(234,"F3",airline1,"DEL","HYD",4,2,15,16,1000, FareType.F3, List.of(new Seat("29a"),new Seat("1b"),new Seat("1b")));
        Flight f4 = new Flight(456,"F4",airline1,"AMD","CCU",10,2,22,22,1000, FareType.F5, List.of(new Seat("29b"),new Seat("1b"),new Seat("1b")));
        Flight f5 = new Flight(987,"F5",airline2,"DEL","BLR",6,2,11,16,2500, FareType.F11, List.of(new Seat("1b"),new Seat("1b"),new Seat("1b")));
        Flight f6 = new Flight(1001,"F6",airline2,"DEL","HYD",5,2,9,12,2300, FareType.F1, List.of(new Seat("1b"),new Seat("1b"),new Seat("1b")));
        flightManager.addFlight(f1);
        flightManager.addFlight(f2);
        flightManager.addFlight(f3);
        flightManager.addFlight(f4);
        flightManager.addFlight(f5);
        flightManager.addFlight(f6);

        User u1 = new User(1,"Vinit",1500);
        User u2 = new User(2,"Neha",1500);
        userManager.addUser(u1);
        userManager.addUser(u2);
        Scanner scanner = new Scanner(System.in);

        AirLineFlightBookingUserManager manager = new AirLineFlightBookingUserManager(flightManager.getAllFlights(),userManager.getAllUsers(), airlineManager.getAirlines());
        String option2 = "N";
        do {
            System.out.println("Please enter the activity you wanted to do \n 1.ADD USER \n 2.SEARCH FLIGHT \n 3.BOOKFLIGHT");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Please enter the userId you want to add a user");
                    int userId = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Please enter the userName you want to add a user");
                    String userName = scanner.nextLine();
                    System.out.println("Please enter the amount you want to add a user");
                    float amount = scanner.nextFloat(); scanner.nextLine();
                    User user = new User(userId,userName,amount);
                    userManager.addUser(user);
                    break;
                case 2:
                    System.out.println("please entetr details for search flight");
                    System.out.println("From");
                    String from = scanner.nextLine();
                    System.out.println("To");
                    String to = scanner.nextLine();
                    System.out.println("Depart Date");
                    int depart = scanner.nextInt();
                    System.out.println("Arrival Date");
                    int arrival = scanner.nextInt();
                    System.out.println(" Seats Needed");
                    int seatsNeeded = scanner.nextInt(); scanner.nextLine();
                    break;
                case 3:
                    System.out.println("please entetr details for book flight");
                    System.out.println("userId");
                    int userId1 = scanner.nextInt(); scanner.nextLine();
                    System.out.println("From");
                    String fromF = scanner.nextLine();
                    System.out.println("To");
                    String toF = scanner.nextLine();
                    System.out.println("Flight Number");
                    String flightNumber = scanner.nextLine();
                    System.out.println("Airline");
                    String airline = scanner.nextLine();
                    System.out.println("Depart Date");
                    int departDate = scanner.nextInt();
                    System.out.println("fare type");
                    int arrivalDate = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Seats Please enter comma seperated example 1a,2b,3c");
                    String seats = scanner.nextLine();
                    List<String> seat = Arrays.asList(seats.split(","));
                    break;
            }
            System.out.println("Do you want to continue? (Y/N)");
            option2 = scanner.nextLine();
             if(option2.equals("N")){
                 System.out.println("Thank you for using Airline Booking System!");
             }
             else{
                 System.out.println("User wanted to perform more options");
             }

        }while(option2.equalsIgnoreCase("Y"));

        // Flight can multiple Fares->
        // Flight -> number, name, clour,  fareType, seat, airline, price
        // Seat -> col , row
        // FareType can be - BUSINESS , ECONOMY
        // SeatState - BOOKED, NONE, NOT_BOOKED, DAMAGAED
        // User can add money in his wallet - (UserId , name , fund)
        // User ( first_name, last_name , is_active, user_name , fund_id,) can One Fund

        // First I should be able add User and Funds for User
        // Then User should be able to search flight
        // Then After search he should be able to book the Flight - It involves that payment deduction, seat marking book available
        // Errors - Seat not available, fund not enough, Flight is  canceled
        //

        // IMP
        // Exception handling
        // Concurrency
        // Modular
        // Extendable
    }
}