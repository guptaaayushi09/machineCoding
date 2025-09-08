package machineCoding.parkingLot;
import machineCoding.parkingLot.vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

import machineCoding.parkingLot.parkingSpot.ParkingSpot;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTimeStamp;
    private long exitTimeStamp;

    public ParkingTicket(Vehicle vehicle,ParkingSpot spot){
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTimeStamp = new Date().getTime();
    }



    public void setExitTime(){
        this.exitTimeStamp = new Date().getTime();
    }

    public String getTicketId(){
        return this.ticketId;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    public ParkingSpot getSpot(){
        return this.spot;
    }
    public long getEntryTime(){
        return this.entryTimeStamp;

    }
    public long getExitTimeStamp(){
        return this.exitTimeStamp;
    }

}
