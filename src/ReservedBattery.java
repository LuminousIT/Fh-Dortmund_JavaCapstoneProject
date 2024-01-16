public class ReservedBattery {
	private final int id;
    private boolean isFullyCharged;

    public ReservedBattery(int id) {
        this.id = id;
        this.isFullyCharged = false; // Newly created battery is not fully charged
    }

    public int getId() {
        return id;
    }

    public boolean isFullyCharged() {
        return isFullyCharged;
    }

    public void markAsFullyCharged() {
        isFullyCharged = true;
    }

}
