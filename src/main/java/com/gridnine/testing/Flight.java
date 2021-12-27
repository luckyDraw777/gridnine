package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Flight implements FlightFilter {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean isDepartureBeforeCurrentTime() {
        return segments.stream().anyMatch(s -> s.getDepartureDate().isAfter(LocalDateTime.now()));
    }

    @Override
    public boolean isArrivalDateBeforeDepartureDate() {
        return segments.stream().anyMatch(s -> s.getArrivalDate().isBefore(s.getDepartureDate()));
    }

    @Override
    public boolean isGroundTimeExceedTwoHours() {

        int counter = 0;

        if(segments.size() > 1){
            for(int i = 0; i < segments.size() - 1; i++){
                counter += Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours();
            }
        }

        return counter < 2;
    }
}
