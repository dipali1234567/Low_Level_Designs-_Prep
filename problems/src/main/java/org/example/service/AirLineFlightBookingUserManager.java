package org.example.service;

import org.example.dto.Airline;
import org.example.dto.Flight;
import org.example.dto.User;

import java.util.List;

public class AirLineFlightBookingUserManager {

    public AirLineFlightBookingUserManager(List<Flight> flights, List<User> users, List<Airline> airlines) {
        this.flights = flights;
        this.users = users;
        this.airlines = airlines;
    }

    List<Flight> flights;
    List<User> users;
    List<Airline> airlines;

    public AirLineFlightBookingUserManager() {

    }


    public void bookFlight() {

    }


}
