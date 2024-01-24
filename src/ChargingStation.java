import java.io.BufferedWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

public class ChargingStation implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(ChargingStation.class.getName());
	private static final int MAX_WAIT_TIME = 5; // Maximum wait time in seconds
	ChargingStationLoggers chargingStationLogger = new ChargingStationLoggers();
	UsersLoggers usersLoggers = new UsersLoggers();

	private String location; // Station Location or Name or Representation
	private boolean available = true;
	private int maxCapacity; // Maximum charging capacity of the station
	private int currentCapacity; // Current available charging slots

	private EnergySource energySource;
	EnergyManagementSystem energyManagementSystem = new EnergyManagementSystem();

	Queue<Car> cSQueue = new LinkedList<Car>();
	Queue<User> userQueue = new LinkedList<User>();

	public ChargingStation(String location, int maxCapacity) {
		this.location = location;
		this.maxCapacity = maxCapacity;
		this.available = true;
		this.currentCapacity = maxCapacity;
		this.energySource = energyManagementSystem.getRandomEnergySource();
	}

	public void setAvailability(boolean isAvailable) {
		this.available = isAvailable;
	}

	public boolean getAvailability() {
		return this.available;
	}

	public void simulateCarArrival(Car car, User user) {
		cSQueue.add(car);
		userQueue.add(user);
	}

	public void startChargingCarWithLogs() {
		Thread chargingThread = new Thread(new Runnable() {
			public void run() {
				LOGGER.info("Thread starts for " + location);
				LOGGER.info(location + " is using Energy Source  " + energySource + " to charge the Car");

				chargingStationLogger.logActivity("Thread starts for " + location);
				chargingStationLogger
						.logActivity(location + " is using Energy Source  " + energySource + " to charge the Car");

				while (!cSQueue.isEmpty()) {

					setAvailability(false);
					Car car = cSQueue.poll();
					User user = userQueue.poll();
					int timeCounter = 0;

					LOGGER.info(car.getName() + " will charge for  " + car.getMaxWaitTime() + " seconds");
					chargingStationLogger
							.logActivity(car.getName() + " will charge for  " + car.getMaxWaitTime() + " seconds");
					usersLoggers.logActivity(user.getFullname() + " is meant to charge for " + car.getMaxWaitTime()
							+ ". " + location + " charging time is " + MAX_WAIT_TIME);

					while (timeCounter < car.getMaxWaitTime()) {
						try {
							LOGGER.info(car.getName() + " is in queue charging for  " + (timeCounter + 1)
									+ " seconds at " + location);
							chargingStationLogger.logActivity(car.getName() + " is in queue charging for  "
									+ (timeCounter + 1) + " seconds at " + location);

							Thread.sleep(1000); // delay for 1 second
							timeCounter++;
							if (timeCounter == MAX_WAIT_TIME) { // if car has charged for charging station maxWaitTime,
																// kickout and pick next car in queue if any exist
								int timeLeftTillFullCharge = car.getMaxWaitTime() - timeCounter;
								LOGGER.info(car.getName() + " has charged for  " + MAX_WAIT_TIME
										+ " seconds and left/kicked the queue.");
								chargingStationLogger.logActivity(car.getName() + " has charged for  " + MAX_WAIT_TIME
										+ " seconds and left/kicked out of the queue. " + timeLeftTillFullCharge
										+ " seconds left till full charge");
								usersLoggers.logActivity(user.getFullname() + " " + car.getName() + " has charged for  "
										+ MAX_WAIT_TIME + " seconds and left/kicked out of the queue. "
										+ timeLeftTillFullCharge + " seconds left till full charge");
								
								break;
							}
						} catch (Exception error) {
							LOGGER.info("Error in " + car.getName() + ". Error Message: " + error.getMessage());
							chargingStationLogger.logActivity(
									"Error in " + car.getName() + ". Error Message: " + error.getMessage());

						}
					}
					LOGGER.info(car.getName() + " is done charging at  " + timeCounter + " seconds");
					chargingStationLogger
							.logActivity(car.getName() + " is done charging at  " + timeCounter + " seconds");
					usersLoggers.logActivity(user.getFullname() + " " + car.getName() + " is done charging at  "
							+ timeCounter + " seconds");

				}
				setAvailability(true);

				if (cSQueue.isEmpty()) {
//					LOGGER.info(location + " is done charging all cars in it's station...");
					System.out.println(location + " is done charging all cars in its station...");
					chargingStationLogger.logActivity(location + " is done charging all cars in its station...");

				}
			}
		});

		chargingThread.start();

	}

	public void startChargingCar() {

		Thread chargingThread = new Thread(new Runnable() {
			public void run() {
				LOGGER.info("Thread starts for " + location);
				LOGGER.info(location + " is using Energy Source  " + energySource + " to charge the Car");

				while (!cSQueue.isEmpty()) {

					setAvailability(false);
					Car car = cSQueue.poll();
					User user = userQueue.poll();
					int timeCounter = 0;

					LOGGER.info(car.getName() + " will charge for  " + car.getMaxWaitTime() + " seconds");

					while (timeCounter < car.getMaxWaitTime()) {
						try {
							LOGGER.info(car.getName() + " is in queue charging for  " + (timeCounter + 1)
									+ " seconds at " + location);
							chargingStationLogger.logActivity(car.getName() + " is in queue charging for  "
									+ (timeCounter + 1) + " seconds at " + location);

							Thread.sleep(1000); // delay for 1 second
							timeCounter++;
							if (timeCounter == MAX_WAIT_TIME) { // if car has charged for charging station maxWaitTime,
																// kickout and pick next car in queue if any exist
								int timeLeftTillFullCharge = car.getMaxWaitTime() - timeCounter;
								LOGGER.info(car.getName() + " has charged for  " + MAX_WAIT_TIME
										+ " seconds and left/kicked the queue." + timeLeftTillFullCharge
										+ " seconds left till full charge");

								break;
							}
						} catch (Exception error) {
							LOGGER.info("Error in " + car.getName() + ". Error Message: " + error.getMessage());

						}
					}
					LOGGER.info(car.getName() + " is done charging at  " + timeCounter + " seconds");

				}
				setAvailability(true);

				if (cSQueue.isEmpty()) {			
					System.out.println(location + " is done charging all cars in its station...");

				}
			}
		});

		chargingThread.start();

	}

	public synchronized boolean isAvailable() {
		return currentCapacity > 0; // Check if there are available slots for charging
	}

	public String getLocation() {
		return location;
	}

	public int getMaxWaitTime() {
		return this.maxCapacity;
	}

	public void chargeBattery(ReservedBattery battery, EnergySource energySource) {
		try {
			LOGGER.info("Charging battery " + battery.getId() + " with " + energySource + " energy source.");
			// Simulating charging process
			Thread.sleep(3000); // Charging time (in milliseconds)
			LOGGER.info("Battery " + battery.getId() + " charged successfully.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void optimizeCharging() {
		energyManagementSystem.optimizeEnergyUsage();
		LOGGER.info("Charging optimization completed.");
	}

	public void reportChargingStatus() {
		energyManagementSystem.reportEnergyStatus();
	}

}
