import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class ChargingStationTest {

    @Test
    public void testChargeBatteryWithEnergySource() {
        ChargingStation chargingStation = new ChargingStation("Location A", 3);
        ReservedBattery battery = new ReservedBattery(1);
        EnergyManagementSystem energyManagementSystem = new EnergyManagementSystem();
        chargingStation.energyManagementSystem = energyManagementSystem;

        chargingStation.chargeBattery(battery, EnergySource.SOLAR);

        // Assert
        assertTrue(battery.isFullyCharged(), "Battery should be fully charged");
        assertEquals(EnergySource.SOLAR, battery.getId(), "Charging source should be SOLAR");
      
    }

    @Test
    public void testChargeBatteryWithEnergySourceAndAmount() {
        ChargingStation chargingStation = new ChargingStation("Location B", 2);
        ReservedBattery battery = new ReservedBattery(2);
        EnergyManagementSystem energyManagementSystem = new EnergyManagementSystem();
        chargingStation.energyManagementSystem = energyManagementSystem;

        chargingStation.chargeBattery(battery, EnergySource.WIND, 50);

    
        assertTrue(battery.isFullyCharged(), "Battery should be fully charged");
        assertEquals(EnergySource.WIND, battery.getId(), "Charging source should be WIND");

    }

    @Test
    public void testReportChargingStatus() {
        ChargingStation chargingStation = new ChargingStation("Location D", 3);
        EnergyManagementSystem energyManagementSystem = new EnergyManagementSystem();
        chargingStation.energyManagementSystem = energyManagementSystem;

        // Redirect logging output to capture log messages
        Logger logger = Logger.getLogger(ChargingStation.class.getName());
        Handler handler = new TestHandler();
        logger.addHandler(handler);

        chargingStation.reportChargingStatus();

        assertTrue(((TestHandler) handler).getLogMessages().contains("Energy Status:"));
    }


    private static class TestHandler extends Handler {
        private StringBuilder logMessages = new StringBuilder();

        public void publish(java.util.logging.LogRecord record) {
            logMessages.append(record.getMessage()).append("\n");
        }

        public void flush() {
        }

        public void close() throws SecurityException {
        }

        public String getLogMessages() {
            return logMessages.toString();
        }
    }
}
