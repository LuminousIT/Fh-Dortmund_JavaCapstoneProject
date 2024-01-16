import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * CS => status => isCharging, ChargingFull, Empty
 * 
 * New class,
 * initialize charging stations,
 * initialize two queues
 * queueOne => CS1,
 * queueTwo => CS2,
 * ...method to Get which CS to use. Method accepts CAR & Index of CS as argument.
 * ...puts the car in the queue of CS of index passed in.
 * .....if the status is isCharging, it waits for MAXTIME of CS to be exceeded
 * .....if maxWaitTime of the CS is not exceeded, Car in CS
 * if maxWaitTime of the CS is exceeded, adds a new car from queue to CS
 * if maxWaitTime of the CS is exceeded, and Queue is empty, set Status of CS to Empty
 *  
 * */


public class ChargingStationNew {
	
	
	 ChargingStation chargingStation1 = new ChargingStation("Station A", 7);
     ChargingStation chargingStation2 = new ChargingStation("Station B", 5);

     List<ChargingStation> chargingStationList = List.of(chargingStation1, chargingStation2);  
     
     public void simulateChargingStation(Car car, int index) {
    	 ChargingStation station = chargingStationList.get(index);
    	 station.simulateCarArrival(car);
    	 
    	 if(station.getAvailability()) { //means no thread is running
    		 station.startChargingCar();
    	 }
     }
     
     
}
