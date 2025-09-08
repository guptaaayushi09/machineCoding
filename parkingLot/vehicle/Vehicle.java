package machineCoding.parkingLot.vehicle;

public abstract class Vehicle {
    protected String licensePlate;
    protected VehicleType type;

    public Vehicle(String licensePlate,VehicleType type){
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getlicensePlate(){
        return this.licensePlate;
    }
    public VehicleType getVehicleType(){
      return this.type;
    }

    
}
