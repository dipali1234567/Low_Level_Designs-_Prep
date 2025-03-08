package org.example.dto;

import org.example.enums.SeatState;

public class Seat {
    private int id;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatState getSeatState() {
        return seatState;
    }

    public void setSeatState(SeatState seatState) {
        this.seatState = seatState;
    }

    public Seat( String seatNumber) {
        this.seatNumber = seatNumber;
        this.seatState = SeatState.AVAILABLE;
    }

    public Seat( String seatNumber, SeatState seatState) {
        this.seatNumber = seatNumber;
        this.seatState = seatState;
    }

    private String seatNumber;
    SeatState seatState;


}
