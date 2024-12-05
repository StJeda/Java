package org.example.specapi;

import org.example.specapi.controllers.AutoBaseController;
import org.example.specapi.models.CarBase.Driver;
import org.example.specapi.models.CarBase.Request;
import org.example.specapi.models.CarBase.Trip;
import org.example.specapi.models.CarBase.Vehicle;
import org.example.specapi.services.AutoBaseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutoBaseControllerTest {

    @Test
    public void testAssignTrip() {
        AutoBaseService service = new AutoBaseService();
        AutoBaseController controller = new AutoBaseController(service);

        Trip trip = new Trip(
                new Driver("John Doe", 5, 5000),
                new Vehicle("Truck", 1000, true),
                new Request("City", 500, "Food"),
                false,
                false);

        String response = controller.assignTrip(trip);

        assertEquals("Trip assigned successfully", response);
        assertTrue(controller.getTrips().contains(trip));
    }

    @Test
    public void testCompleteTrip() {
        AutoBaseService service = new AutoBaseService();
        AutoBaseController controller = new AutoBaseController(service);

        Trip trip = new Trip(
                new Driver("John Doe", 5, 5000),
                new Vehicle("Truck", 1000, true),
                new Request("City", 500, "Food"),
                false,
                false);

        controller.assignTrip(trip);

        String response = controller.completeTrip(trip);

        assertEquals("Trip updated to completed", response);
        assertTrue(controller.getTrips().stream().anyMatch(Trip::completed));
    }
}
