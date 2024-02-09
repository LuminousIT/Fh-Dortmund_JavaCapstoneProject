import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogFileManagerTest {
	 private LogFileManager logFileManager;

	    @BeforeEach
	    public void setUp() {
	        logFileManager = new LogFileManager();
	    }

	    @Test
	    public void testGetRequestedLogFiles_WithValidSearchTerm() throws IOException {
	        Path tempDir = Files.createTempDirectory("test_logs");
	        Path logFile1 = Files.createFile(Paths.get(tempDir.toString(), "equipment1_log.txt"));
	        Path logFile2 = Files.createFile(Paths.get(tempDir.toString(), "equipment2_log.txt"));
	        Path logFile3 = Files.createFile(Paths.get(tempDir.toString(), "2023-01-01_log.txt"));

	        String searchTerm = "equipment1";

	        List<String> foundFiles = logFileManager.getRequestedLogFiles(searchTerm);

	        assertEquals(1, foundFiles.size());
	        assertEquals(logFile1.toString(), foundFiles.get(0));

	        Files.deleteIfExists(logFile1);
	        Files.deleteIfExists(logFile2);
	        Files.deleteIfExists(logFile3);
	        Files.deleteIfExists(tempDir);
	    }

	    @Test
	    public void testGetRequestedLogFiles_WithInvalidSearchTerm() {
	        String searchTerm = "invalid_equipment";

	        List<String> foundFiles = logFileManager.getRequestedLogFiles(searchTerm);

	        assertEquals(0, foundFiles.size());
	    }

}
