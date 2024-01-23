import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class ChargingStationLoggers extends BaseLogger  {
	
	public ChargingStationLoggers() {
		
	}
	 @Override
	 public void log(String message) {
		 super.log("ChargingStationLogger: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
//		 super.log("ChargingStationLogger: " + message);
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("charging_station_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}

class ChargingSimulationLoggers extends BaseLogger  {
	
	public ChargingSimulationLoggers() {
		
	}
	 @Override
	 public void log(String message) {
		 super.log("ChargingSimulationLoggers: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("charging_simulation_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}

class ChargingStationSimulationLoggers extends BaseLogger  {
	
	public ChargingStationSimulationLoggers() {
		
	}
	 @Override
	 public void log(String message) {
		 super.log("ChargingStationSimulationLoggers: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("charging_station_simulation_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}


class EnergyManagementSystemLoggers extends BaseLogger {
	 @Override
	 public void log(String message) {
		 super.log("EnergyManagementSystemLoggers: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
		 super.log("EnergyManagementSystemLoggers: " + message);
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("energy_management_system_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}

class UsersLoggers extends BaseLogger {
	 @Override
	 public void log(String message) {
		 super.log("UsersLoggers: " + message);
	 }
	 
	 @Override
	 public void logActivity(String message) {
//		 super.log("UsersLoggers: " + message);
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("users_log.txt", true))) {
	            writer.write(message);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}


