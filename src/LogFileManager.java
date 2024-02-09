import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//  user should be able to open the requested log file based on the name of equipment or date

public class LogFileManager {
	private static final Logger LOGGER = Logger.getLogger(LogFileManager.class.getName());

    // Method to search and retrieve log files based on equipment name or date
    public List<String> getRequestedLogFiles(String searchTerm) {
        List<String> foundFiles = new ArrayList<>();
        try {
            Files.walk(Paths.get("logs"), FileVisitOption.FOLLOW_LINKS)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().contains(searchTerm)) // Search based on equipment name or date
                    .forEach(path -> foundFiles.add(path.toString()));
        } catch (IOException e) {
            LOGGER.warning("Error while searching for log files: " + e.getMessage());
        }
        return foundFiles;
    }
}
