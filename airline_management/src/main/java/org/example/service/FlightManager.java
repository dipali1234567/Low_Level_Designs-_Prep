package org.example.service;

import org.example.dto.Flight;
import org.example.dto.FlightSearch;

import java.util.List;

public interface FlightManager {



    public Flight addFlight(Flight flight);
    public Flight updateFlight(Flight flight);
    public Flight deleteFlight(Flight flight);
    public Flight getFlightById(String id);
    public List<Flight> getAllFlights();
    public List<Flight> searchFlight(FlightSearch flightSearch);

}
