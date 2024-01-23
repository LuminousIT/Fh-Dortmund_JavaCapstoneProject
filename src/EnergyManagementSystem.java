import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class EnergyManagementSystem {
	private static final Logger LOGGER = Logger.getLogger(EnergyManagementSystem.class.getName());
	private Map<EnergySource, Integer> availableEnergy;

	public EnergyManagementSystem() {
		availableEnergy = new HashMap<>();
		// Initialize available energy for each source (e.g., solar, wind, grid)
		for (EnergySource source : EnergySource.values()) {
			availableEnergy.put(source, 100); // Example: 100 units initially available for each source
		}
	}
	
	public EnergySource getRandomEnergySource() {
		EnergySource[] energySources = EnergySource.values();
		Random random = new Random();
		return energySources[random.nextInt(energySources.length)];
	}

	public synchronized boolean allocateEnergy(EnergySource source, int amount) {
		int currentAvailable = availableEnergy.getOrDefault(source, 0);
		if (currentAvailable >= amount) {
			availableEnergy.put(source, currentAvailable - amount);
			LOGGER.info("Allocated " + amount + " units of " + source + " energy.");
			return true;
		} else {
			LOGGER.warning("Insufficient " + source + " energy.");
			return false;
		}
	}

	public synchronized void optimizeEnergyUsage() {
		// Example: Simple optimization - allocating energy randomly to simulate an
		// optimization algorithm
		Random random = new Random();
		for (EnergySource source : EnergySource.values()) {
			int available = availableEnergy.getOrDefault(source, 0);
			int newAllocation = random.nextInt(available + 1); // Allocate random amount within available energy
			availableEnergy.put(source, available - newAllocation);
			LOGGER.info("Optimized " + newAllocation + " units of " + source + " energy.");
		}
	}

	public synchronized void reportEnergyStatus() {
		// Log current available energy for each source
		LOGGER.info("Energy Status:");
		for (EnergySource source : EnergySource.values()) {
			int available = availableEnergy.getOrDefault(source, 0);
			LOGGER.info(source + " : " + available + " units");
		}
	}

}
