package machineCoding.parkingLot;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import machineCoding.parkingLot.price.*;
import machineCoding.parkingLot.vehicle.Vehicle;
import java.util.Optional;
import machineCoding.parkingLot.parkingSpot.ParkingSpot;

public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();
    private final List<ParkingFloor> floors = new ArrayList<>();
    private PriceStrategy priceStrategy;
    private final Map<String,ParkingTicket> activeTickets = new ConcurrentHashMap<>();

    private ParkingLot(){
         priceStrategy = new PriceBasedOnhours();
    }

    public static synchronized ParkingLot getInstance(){
        return INSTANCE;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }
    public void setPriceStrategy(PriceStrategy strategy){
        this.priceStrategy = strategy;
    }
    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws Exception{
       for(ParkingFloor floor:floors){
        Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle);
        if(spotOpt.isPresent()){
            ParkingSpot spot = spotOpt.get();
            if(spot.assignVehicle(vehicle)){
                ParkingTicket ticket = new ParkingTicket(vehicle, spot);
                activeTickets.put(vehicle.getlicensePlate(),ticket);
                return ticket;
            }
        }

       }
        throw new Exception("No available spot for"+ vehicle.getVehicleType());
    }
    public synchronized double unParkVehicle(String license) throws Exception{
       ParkingTicket ticket = activeTickets.remove(license);
       if(ticket == null) throw new Exception("Ticket not found");
       ticket.getSpot().removeVehicle();
       ticket.setExitTime();
       return priceStrategy.calculatePrice(ticket);
    }

}
