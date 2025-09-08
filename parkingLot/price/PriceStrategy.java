package machineCoding.parkingLot.price;
import machineCoding.parkingLot.ParkingTicket;
public interface PriceStrategy {
     double calculatePrice(ParkingTicket parkingTicket);
}
