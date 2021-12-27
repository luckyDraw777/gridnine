package com.gridnine.testing;

public interface FlightFilter {

    boolean isDepartureBeforeCurrentTime();
    boolean isArrivalDateBeforeDepartureDate();
    boolean isGroundTimeExceedTwoHours();
}
