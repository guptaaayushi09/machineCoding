package machineCoding.bookMyShow.seat;

public class Seat {
    private final String id;
    private final int row;
    private final int col;
    private final SeatType type;
    private final Double price;
    private SeatStatus status;

    public Seat(String id,int row,int col,SeatType type,double price,SeatStatus status){
       this.id = id;
       this.row = row;
       this.col = col;
       this.price = price;
       this.type = type;
       this.status = status;
    }
    public void setStatus(SeatStatus status){
        this.status = status;
    }

    public String getID(){
        return this.id;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public SeatType getType(){
        return this.type;
    }
   public SeatStatus getStatus(){
    return this.status;
   }
   public double getPrice(){
    return this.price;
   }

}
