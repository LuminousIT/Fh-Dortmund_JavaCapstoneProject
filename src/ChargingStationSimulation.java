import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChargingStationSimulation {
	private static final Logger LOGGER = Logger.getLogger(ChargingStationSimulation.class.getName());
	static ChargingStationSimulationLoggers chargingStationSimulationLoggers = new ChargingStationSimulationLoggers();
	
	public static void main(String[] args) {
		logSystemEvent("Starting the charging station simulation.");
		
		User[] users = new User[5];
	
		String username[] = {"Jane", "Michael","George", "Johannes", "Servus"};
		String carType[] = {"Tesla", "CyberTruck", "Hummer", "Benz", "Volkswageb"};
		
		ChargingSimulation chargingStationSimulator = new ChargingSimulation();
		
		Random random = new Random();
		for (int i = 0; i < 5; i++) { // Simulating arrival of 5 cars
			int delay = random.nextInt(10);
			int stationIndex = random.nextInt(2); // Randomly choose a station index between 0 and 1
			Car car = new Car("Car" + (i + 1), delay);
			users[i] = new User(username[i], carType[i]); 
			users[i].setCar(car);
			logSystemEvent("Station Index " + stationIndex + ". " + car.getName() + " Max Wait Time: " + delay);
			chargingStationSimulationLoggers.logActivity("Station Index " + stationIndex + ". " + car.getName() + " Max Wait Time: " + delay);
			
			chargingStationSimulator.simulateChargingStation(car, stationIndex, users[i]);
		}
		chargingStationSimulator.runSimulationThread();

	}

	private static void logSystemEvent(String logMessage) {
		LOGGER.info(logMessage);
	}



}
