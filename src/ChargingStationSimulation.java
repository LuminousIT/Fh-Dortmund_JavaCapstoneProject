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
    private static final int MAX_WAIT_TIME = 10; // Maximum wait time in minutes

    public static void main(String[] args) {
        logSystemEvent("Starting the charging station simulation.");
        
        // Set up logging configurations
//        configureLogging();

        ChargingStationNew chargingStationSimulator = new ChargingStationNew();
        
        Random random = new Random();
      for (int i = 0; i < 5; i++) { // Simulating arrival of 5 cars
    	  int delay = random.nextInt(10);
          int stationIndex = random.nextInt(1); // Randomly choose a station index
          Car car = new Car("Car" + (i + 1), delay);
          
          chargingStationSimulator.simulateChargingStation(car, stationIndex);
      }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        ChargingStation chargingStation1 = new ChargingStation("Station A", 7);
//        ChargingStation chargingStation2 = new ChargingStation("Station B", 5);
//
//        List<ChargingStation> chargingStationList = List.of(chargingStation1, chargingStation2);
//        
     // Schedule cars to arrive at charging stations randomly
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2); // Simulating two charging stations
//        
//        Random random = new Random();
//        for (int i = 0; i < 5; i++) { // Simulating arrival of 5 cars
//            int delay = random.nextInt(10); // Represents charging time of car. Random delay in seconds before a car arrives
//            int stationIndex = random.nextInt(1); // Randomly choose a station index
//            ChargingStation station = chargingStationList.get(stationIndex);
//            Car car = new Car("Car" + (i + 1), delay);
//            executor.schedule(() -> station.simulateArrival(car), delay, TimeUnit.SECONDS);
//        }
//        
//        Thread threadOne = new Thread(new Runnable() {
//	        public void run()
//	        {
//	            // code goes here.
//	        	
//	        }});  
//        
//        threadOne.start();

        
        
        
     // Example: Using LogFileManager to find log files based on equipment name or date
//        LogFileManager logFileManager = new LogFileManager();
//        List<String> foundFiles = logFileManager.getRequestedLogFiles("ChargingStation_1");
//
//        if (!foundFiles.isEmpty()) {
//            LOGGER.info("Found log files:");
//            foundFiles.forEach(LOGGER::info);
//            // Perform operations like opening files or displaying file paths to the user
//        } else {
//            LOGGER.info("No log files found for the specified search term.");
//        }


        // Shut down the executor after simulation time
//        executor.shutdown();
//        try {
//            executor.awaitTermination(1, TimeUnit.MINUTES); // Simulation time (1 minute)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    
        logSystemEvent("Simulation complete. Exiting program.");
    }

    private static void logSystemEvent(String logMessage) {
        LOGGER.info(logMessage);
    }
    
//    logs files for each day, each energy source, and system as a whole
    
    public static void configureLogging() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.INFO);

        try {
            Handler fileHandler = new FileHandler("logs/%g_system.log", 1000000, 10, true); // System log file
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);

            // Create loggers for each energy source
            for (EnergySource source : EnergySource.values()) {
                Logger sourceLogger = Logger.getLogger(source.toString());
                sourceLogger.setLevel(Level.INFO);
                Handler sourceHandler = new FileHandler("logs/" + source.toString() + "_%g.log", 1000000, 10, true);
                sourceHandler.setFormatter(new SimpleFormatter());
                sourceLogger.addHandler(sourceHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static EnergySource getRandomEnergySource() {
        EnergySource[] sources = EnergySource.values();
        int index = (int) (Math.random() * sources.length);
        return sources[index];
    }
    
    
}
