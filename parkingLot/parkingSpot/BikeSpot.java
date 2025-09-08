package machineCoding.parkingLot.parkingSpot;

import machineCoding.parkingLot.vehicle.Vehicle;
import machineCoding.parkingLot.vehicle.VehicleType;

public class BikeSpot extends ParkingSpot {
    public BikeSpot(String spotId){
        super(spotId);
    }
    @Override
    public boolean canFitVehicle(Vehicle vehicle){
        return vehicle.getVehicleType() == VehicleType.BIKE;
    }
    
}
