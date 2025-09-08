package machineCoding.parkingLot.price;

import machineCoding.parkingLot.ParkingTicket;

public class PriceBasedOnhours implements PriceStrategy{
        private static final double RATE_PER_HOUR = 10.0;
        @Override
        public double calculatePrice(ParkingTicket ticket){
            long duration = ticket.getEntryTime() -ticket.getExitTimeStamp();
            long hrs = (long) Math.ceil((double) duration / (1000 * 60 * 60));
            return hrs *RATE_PER_HOUR;
        } 
}
