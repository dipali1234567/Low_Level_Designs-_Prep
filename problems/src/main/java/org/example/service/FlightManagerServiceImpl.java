package org.example.service;

import org.example.dto.Flight;
import org.example.dto.FlightSearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlightManagerServiceImpl implements FlightManager {

    private List<Flight> flights = new ArrayList<>();

    @Override
    public Flight addFlight(Flight flight) {
       flights.add(flight);
       return flight;
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return null;
    }

    @Override
    public Flight deleteFlight(Flight flight) {
        return null;
    }

    @Override
    public Flight getFlightById(String id) {
        return null;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public List<Flight> searchFlight(FlightSearch flightSearch) {
         return flights.stream().filter(f-> (flightSearch.getFrom()==null || flightSearch.getFrom().equalsIgnoreCase(f.getFrom())))
                 .filter(f-> (flightSearch.getTo()==null || flightSearch.getTo().equalsIgnoreCase(f.getTo())) )
                 .filter(f-> (flightSearch.getAirline()==null || flightSearch.getAirline().equals(f.getAirline())))
                 .filter(f-> (flightSearch.getAvailableSeat()==0 || flightSearch.getAvailableSeat()==f.getSeatList().size()))
                 .filter(f-> (flightSearch.getDeparture()==0 || flightSearch.getDeparture()==f.getDepartureDate()))
                 .sorted(getFlightComparator(flightSearch.getSortBy(),flightSearch.getSortType()))
         .collect(Collectors.toList());
    }

    private Comparator<Flight> getFlightComparator(String sortedBy, String sortType){
        if(sortedBy==null)
            return Comparator.comparing(Flight::getFlightName);

        Comparator<Flight> comparator;
        switch (sortedBy){
            case "from": comparator = Comparator.comparing(Flight::getFrom); break;
            case "to": comparator = Comparator.comparing(Flight::getTo); break;
//            case "airline": comparator = Comparator.comparing(Flight :: getAirline); break;
//            case "availableSeat": comparator = Comparator.comparing(Flight :: getSeatList) break;
            case "departure": comparator = Comparator.comparing(Flight::getDepartureDate); break;
            default: comparator = Comparator.comparing(Flight::getFlightName);
        }

        switch (sortType){
            case "asc" : break;
            case "desc" : comparator = comparator.reversed();

        }
        return comparator;
    }
}
