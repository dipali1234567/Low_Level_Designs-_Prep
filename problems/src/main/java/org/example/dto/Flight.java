package org.example.dto;

import org.example.enums.FareType;

import java.util.List;


public class Flight {

    private int id;
    private String flightName;
    private int availableSeats;
    List<Seat> seatList;
    private String from;
    private String to;
    private int departureTime;
    private int arrivalTime;
    private int departureDate;
    private FareType fareType;
    private Airline airline;
    private float price;

    public Flight() {
    }


    public Flight(int id, String flightName,Airline airline, String from, String to,int availableSeats,int departureDate, int departureTime, int arrivalTime, float price,  FareType fareType, List<Seat> seatList) {
        this.id = id;
        this.flightName = flightName;
        this.availableSeats = availableSeats;
        this.seatList = seatList;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.fareType = fareType;
        this.airline = airline;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

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

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(int departureDate) {
        this.departureDate = departureDate;
    }

    public FareType getFareType() {
        return fareType;
    }

    public void setFareType(FareType fareType) {
        this.fareType = fareType;
    }
    public Airline getAirline() {
        return airline;
    }
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
