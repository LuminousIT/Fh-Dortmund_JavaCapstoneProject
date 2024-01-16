import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggersTest {

    @Test
    public void testLogging() throws IOException {
        ChargingStationLoggers chargingStationLogger = new ChargingStationLoggers();
        EnergyManagementSystemLoggers energyLogger = new EnergyManagementSystemLoggers();
        UsersLoggers usersLogger = new UsersLoggers();

        String logMessage = "Test log message";

     
        chargingStationLogger.logActivity(logMessage);
        energyLogger.logActivity(logMessage);
        usersLogger.logActivity(logMessage);

        assertEquals(logMessage + System.lineSeparator(), getLastLine("charging_station_log.txt"));
        assertEquals(logMessage + System.lineSeparator(), getLastLine("energy_management_system_log.txt"));
        assertEquals(logMessage + System.lineSeparator(), getLastLine("users_log.txt"));
    }

    private String getLastLine(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String lastLine = null;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            return lastLine;
        }
    }
}
