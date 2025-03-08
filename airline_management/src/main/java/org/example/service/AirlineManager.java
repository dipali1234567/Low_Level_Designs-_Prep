package org.example.service;

import org.example.dto.Airline;

import java.util.List;

public interface AirlineManager {

    List<Airline> getAirlines();

     Airline addAirline(Airline airline) ;
}
