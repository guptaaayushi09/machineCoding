package machineCoding.parkingLot;
import machineCoding.parkingLot.vehicle.Vehicle;
import java.util.List;
import java.util.Optional;

import machineCoding.parkingLot.parkingSpot.ParkingSpot;

public class ParkingFloor {
     private final int parkingFloor;
    private final List<ParkingSpot>spots;

    public ParkingFloor(int floor,List<ParkingSpot> spots){
        this.spots= spots;
        this.parkingFloor = floor;
    }

public synchronized Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle){

    return spots.stream().filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle)).findFirst();
}
    public int getParkingFloor(){
        return this.parkingFloor;
    }
}
