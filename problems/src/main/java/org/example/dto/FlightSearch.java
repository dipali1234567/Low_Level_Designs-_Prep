package org.example.dto;

import org.example.enums.FareType;

public class FlightSearch {
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public FlightSearch(String from, String to, int departure, int availableSeat, Airline airline, String sortBy, String sortType) {
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.availableSeat = availableSeat;
        this.airline = airline;
        this.sortBy = sortBy;
        this.sortType = sortType;
    }

    private String from;
    private String to;
    private int departure;
    private int availableSeat;
    private Airline airline;
    private String sortBy;
    private String sortType;

    //from, to, departDate, paxCount
    // from, to, departDate, paxCount, preferredAirline, sortBy, SortType
}
