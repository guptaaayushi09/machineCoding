package machineCoding.parkingLot.parkingSpot;

import machineCoding.parkingLot.vehicle.Vehicle;
import machineCoding.parkingLot.vehicle.VehicleType;

public class LargeSpot extends ParkingSpot {

    public LargeSpot(String spotId){
        super(spotId);
    }

    @Override 
    public boolean canFitVehicle(Vehicle vehicle){
     return vehicle.getVehicleType() == VehicleType.TRUCK;
    }
}
