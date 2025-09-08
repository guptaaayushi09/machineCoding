package machineCoding.parkingLot.parkingSpot;

import machineCoding.parkingLot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isOccupied = false;
    }
    public abstract boolean canFitVehicle(Vehicle vehicle);

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if (isAvailable()) {
            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public synchronized void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
    public String getSpotId() {
        return this.spotId;
    }
}
