package org.example.specapi.controllers;

import org.example.specapi.models.CarBase.Trip;
import org.example.specapi.services.AutoBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autobase")
public class AutoBaseController {
    private final AutoBaseService autoBaseService;

    public AutoBaseController(AutoBaseService autoBaseService) {
        this.autoBaseService = autoBaseService;
    }

    @PostMapping("/assign")
    public String assignTrip(@RequestBody Trip trip) {
        return autoBaseService.assignTrip(trip);
    }

    @GetMapping("/trips")
    public List<Trip> getTrips() {
        return autoBaseService.getTrips();
    }

    @PostMapping("/complete")
    public String completeTrip(@RequestBody Trip trip) {
        return autoBaseService.completeTrip(trip);
    }
}
