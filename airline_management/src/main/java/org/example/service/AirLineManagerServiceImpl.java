package org.example.service;

import org.example.dto.Airline;

import java.util.ArrayList;
import java.util.List;

public class AirLineManagerServiceImpl implements AirlineManager {

    private List <Airline> airlines = new ArrayList<>();
    @Override
    public List<Airline> getAirlines() {
        return this.airlines;
    }

    @Override
    public Airline addAirline(Airline airline) {
        airlines.add(airline);
        return airline;
    }
}
