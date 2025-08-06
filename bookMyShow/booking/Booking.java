package machineCoding.bookMyShow.booking;
import machineCoding.bookMyShow.*;
import machineCoding.bookMyShow.seat.*;
import java.util.List;
public class Booking{
    private final String id;
    private final User user;
    private final Show show;
    private final List<Seat> seat;
    private final double totalPrice;
    private BookingStatus status;

    public Booking(String id,User user,Show show,List<Seat> seat, double price, BookingStatus status){
        this.id = id;
        this.show = show;
        this.seat = seat;
        this.user = user;
        this.totalPrice = price;
        this.status = status;
    }

   public void setStatus(BookingStatus status){
    this.status = status;
   }

   public BookingStatus getStatus(){
    return this.status;
   }
   public String getId(){
    return this.id;
   }

   public User getUser(){
     return this.user;
   }
public List<Seat> getSeat(){
  return this.seat;
}
public Show getShow(){
    return this.show;
}

public double getPrice(){
    return this.totalPrice;
}

}