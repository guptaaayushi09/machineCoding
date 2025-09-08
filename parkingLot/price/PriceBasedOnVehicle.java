package machineCoding.parkingLot.price;
import java.util.Map;

import machineCoding.parkingLot.ParkingTicket;
import machineCoding.parkingLot.vehicle.VehicleType;

public class PriceBasedOnVehicle implements PriceStrategy{
    private final Map<VehicleType,Double> hourlyPrice = Map.of(VehicleType.BIKE,10.0,VehicleType.CAR,20.0,VehicleType.TRUCK,30.0);

    @Override
    public double calculatePrice(ParkingTicket parkingTicket){
        long duration = parkingTicket.getEntryTime()- parkingTicket.getExitTimeStamp();
        long hrs = (long) Math.ceil((double) duration / (1000 * 60 * 60));
        return hrs*hourlyPrice.get(parkingTicket.getVehicle().getVehicleType());
    }
}
