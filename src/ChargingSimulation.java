import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * 
 * 
 * New class, initialize charging stations, initialize two queues queueOne =>
 * CS1, queueTwo => CS2, ...method to Get which CS to use. Method accepts CAR &
 * Index of CS as argument. ...puts the car in the queue of CS of index passed
 * in. .....if the status is isCharging, it waits for MAXTIME of CS to be
 * exceeded .....if maxWaitTime of the CS is not exceeded, Car in CS if
 * maxWaitTime of the CS is exceeded, adds a new car from queue to CS if
 * maxWaitTime of the CS is exceeded, and Queue is empty, set Status of CS to
 * Empty
 * 
 * 
 */

public class ChargingSimulation {
	ChargingSimulationLoggers chargingSimulationLoggers =  new ChargingSimulationLoggers();
	ChargingStation chargingStation1 = new ChargingStation("Station A", 3);
	ChargingStation chargingStation2 = new ChargingStation("Station B", 2);

	List<ChargingStation> chargingStationList = List.of(chargingStation1, chargingStation2);

	public void simulateChargingStation(Car car, int index, User user) {
		ChargingStation station = chargingStationList.get(index);
		station.simulateCarArrival(car,user);

		System.out.println(car.getName() + " will be charging in " + station.getLocation());
		chargingSimulationLoggers.logActivity(car.getName() + " will be charging in " + station.getLocation());
//    	 if(station.getAvailability()) { 
//    		 station.startChargingCar();
//    	 }
	}

	public void runSimulationThread() {
		ChargingStation station1 = chargingStationList.get(0);
		if (station1.getAvailability()) { // means no thread is running
			station1.startChargingCarWithLogs();
		}
		
		ChargingStation station2 = chargingStationList.get(1);
		if (station2.getAvailability()) {
			station2.startChargingCarWithLogs();
		}
	}


}
