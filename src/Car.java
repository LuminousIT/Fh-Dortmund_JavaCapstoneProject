
public class Car {
	private String name;
    private int maxWaitTime;
    private int chargeLevelInTime;

    public Car(String name, int maxWaitTime) {
        this.name = name;
        this.maxWaitTime = maxWaitTime;
    }

    public String getName() {
        return name;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }
}
