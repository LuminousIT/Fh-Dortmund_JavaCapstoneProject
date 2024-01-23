public class User {
	private String fullname;
	private String carType;
	private UsersLoggers userLog;
	private Car car;
	
	public User(String fullname,  String carType) {
		this.fullname = fullname;
		this.carType = carType;
		
		userLog = new UsersLoggers();
		
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}


	public void setCar(Car car) {
		this.car = car;
	}
	
	public Car getUserCar() {
		return this.car;
	}
	
	
}
