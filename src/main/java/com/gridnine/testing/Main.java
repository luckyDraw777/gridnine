package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();


        System.out.println("Departures later than the current time");
        flights.stream().filter(Flight::isDepartureBeforeCurrentTime).forEach(System.out::println);

        System.out.println("\nDepartures that have segments with an arrival date earlier than the departure date ");
        flights.stream().filter(Flight::isArrivalDateBeforeDepartureDate).forEach(System.out::println);

        System.out.println("\nDepartures with more than two hours of time on the ground");
        flights.stream().filter(Flight::isGroundTimeExceedTwoHours).forEach(System.out::println);

    }
}
