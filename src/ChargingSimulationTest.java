import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChargingSimulationTest {

    @Test
    void simulateChargingStation() {
        ChargingSimulation chargingSimulation = new ChargingSimulation();
        Car car = new Car("TestCar", 10);
        User user = new User("TestUser", "Type1");

        int index = 0; // assuming there is at least one charging station
        chargingSimulation.simulateChargingStation(car, index, user);
        
        LogFileManager logFileManager = new LogFileManager();

        // For example, you can check if the log contains the expected message
        assertTrue(logFileManager.getRequestedLogFiles("charging_simulation_log.txt").contains("will be charging in " + chargingSimulation.chargingStationList.get(index).getLocation()));
    }

    @Test
    void runSimulationThread() {
        ChargingSimulation chargingSimulation = new ChargingSimulation();
        
    
        chargingSimulation.runSimulationThread();

        // For example, you can check if the charging stations have started charging cars
//        assertTrue(chargingSimulation.chargingStationList.stream().allMatch(ChargingStation::isCharging));
    }
}
