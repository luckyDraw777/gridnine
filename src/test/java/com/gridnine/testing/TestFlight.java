package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFlight {



    @Test
    void groundTimeExceedsTwoHours(){
        Flight flight = new Flight(
                Arrays.asList(
                        new Segment(LocalDateTime.of(2021, 1, 1, 1, 0),
                                LocalDateTime.of(2021, 1, 1, 6, 0)))
        );
        assertTrue(flight.isGroundTimeExceedTwoHours());
    }

    @Test
    void departureBeforeNow(){
        Flight flight = new Flight(
                Arrays.asList(new Segment(LocalDateTime.of(2020, 11, 12, 1, 0),
                                LocalDateTime.of(2021, 12, 10, 5, 15)))
        );
        assertFalse(flight.isDepartureBeforeCurrentTime());
    }

    @Test
    void arrivalBeforeDeparture(){
        Flight flight = new Flight(
                Arrays.asList(
                        new Segment(LocalDateTime.of(2021, 5, 5, 5, 5),
                                LocalDateTime.of(2021, 6, 5 ,1, 1)))
        );
        assertFalse(flight.isArrivalDateBeforeDepartureDate());
    }
}
