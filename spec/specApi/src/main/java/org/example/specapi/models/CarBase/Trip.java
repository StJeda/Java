package org.example.specapi.models.CarBase;

public record Trip(Driver driver, Vehicle vehicle, Request request, boolean completed, boolean vehicleDamaged) { }