package org.example.specapi.services;

import lombok.extern.slf4j.Slf4j;
import org.example.specapi.models.CarBase.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AutoBaseService {
    private final List<Trip> trips = new ArrayList<>();

    public String assignTrip(Trip trip) {
        trips.add(trip);
        log.info("Assigned new trip: {}", trip);
        return "Trip assigned successfully";
    }

    public List<Trip> getTrips() {
        log.info("Fetching all trips. Total trips: {}", trips.size());
        return trips;
    }

    public String completeTrip(Trip trip) {
        Optional<Trip> existingTrip = trips.stream()
                .filter(t -> t.equals(trip))
                .findFirst();

        if (existingTrip.isPresent()) {
            Trip completedTrip = new Trip(
                    existingTrip.get().driver(),
                    existingTrip.get().vehicle(),
                    existingTrip.get().request(),
                    true,
                    existingTrip.get().vehicleDamaged()
            );
            trips.set(trips.indexOf(existingTrip.get()), completedTrip);
            log.info("Trip completed: {}", completedTrip);
            return "Trip updated to completed";
        } else {
            log.warn("Trip not found for completion: {}", trip);
            return "Trip not found";
        }
    }
}

