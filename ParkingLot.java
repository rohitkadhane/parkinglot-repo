import java.util.ArrayList;
import java.util.List;


public class ParkingLot
{

    List<CompactSpot> compactSpotList = new ArrayList<>();
    List<LargeSpot> largeSpotList= new ArrayList<>();
    List<BikeSpot> bikeSpotList = new ArrayList<>();

    int freeCompactSpots;
    int freeLargeSpots;
    int freeBikeSpots;

    public ParkingLot( int freeCompactSpots, int freeLargeSpots, int freeBikeSpots)
    {
        this.freeCompactSpots = freeCompactSpots;
        this.freeLargeSpots = freeLargeSpots;
        this.freeBikeSpots = freeBikeSpots;

    }
    //parkingvehicle
    public void parkVehicle(Vehicle vehicle)
    {
        System.out.println(" we are about to park the vehicle of type " + vehicle.getVehicleType());

        if(vehicle.getVehicleType().equals(VehicleType.TRUCK))
{
  
        if(freeLargeSpots>0)
          parkYourLargeVehicle(vehicle);
          else
          System.out.println("Sorry all Large spots are Full ");
            }
            else if (vehicle.getVehicleType().equals(VehicleType.CAR))
            {
                if(freeCompactSpots>0)
                parkYourCompactVehicle(vehicle);
                else if(freeLargeSpots>0)
                parkYourLargeVehicle(vehicle);
                else
                System.out.println("sorry neither Large or Compact spots Availabe");

            }else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
                if(freeBikeSpots>0)
                parkYourBikeVehicle(vehicle);
                else if(freeCompactSpots>0)
                parkYourCompactVehicle(vehicle);
                else if(freeLargeSpots>0)
                parkYourLargeVehicle(vehicle);
                else 
                System.out.println("Sorry neither Large or Bike spots Availabe");
            }
        }
    

void parkYourLargeVehicle(Vehicle vehicle){

   
    LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
    largeSpot.setFree(false);
    largeSpot.setVehicle(vehicle);
    vehicle.setParkingSpot(largeSpot);

    largeSpotList.add(largeSpot);
    System.out.println("we have sucessfully parked your "+ vehicle.getVehicleType()+ "vehicle");
    freeLargeSpots--;

}
void parkYourBikeVehicle(Vehicle vehicle){

   
    BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
    bikeSpot.setFree(false);
    bikeSpot.setVehicle(vehicle);
    vehicle.setParkingSpot(bikeSpot);

    bikeSpotList.add(bikeSpot);
    System.out.println("we have sucessfully parked your "+ vehicle.getVehicleType()+ "vehicle");
    freeBikeSpots--;

}
void parkYourCompactVehicle(Vehicle vehicle){

   
    CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
    compactSpot.setFree(false);
    compactSpot.setVehicle(vehicle);
    vehicle.setParkingSpot(compactSpot);

    compactSpotList.add(compactSpot);
    System.out.println("we have sucessfully parked your "+ vehicle.getVehicleType()+ "vehicle");
    freeCompactSpots--;

}
//unparkedVehicle
public void unparkedVehicle(Vehicle vehicle ){
    System.out.println("we are about to unpark or remove your vehicle of type"+ vehicle.getVehicleType());
    ParkingSpot parkingSpot= vehicle.getParkingSpot();
    //parkingSpot.setFree(true);

    if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
        if(largeSpotList.remove(parkingSpot)){
            System.out.println("we have sucessfully removed your vehicle");
            freeLargeSpots++;

        }
        else 
        System.out.println("you dont hvae vehicle parked at this parking spot");
    }else if ( vehicle.getVehicleType().equals(VehicleType.CAR)){
        if(compactSpotList.remove(parkingSpot)){
            System.out.println("we have sucessfully removed your vehicle ");
            freeCompactSpots++;
        }else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(bikeSpotList.remove(parkingSpot)){
                System.out.println("we have sucessfully removed your vehicle ");
                freeBikeSpots++;

            }
            else 
            System.out.println("you dont have your vehicle parked at this parking lot");
        }
    }
}
}

   