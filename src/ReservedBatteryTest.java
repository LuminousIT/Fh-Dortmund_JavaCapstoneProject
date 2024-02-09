import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReservedBatteryTest {

	@Test
	public void testGetId() {
		ReservedBattery battery = new ReservedBattery(123);
		assertEquals(123, battery.getId());
	}

	@Test
	public void testIsFullyCharged() {
		ReservedBattery battery = new ReservedBattery(456);
		assertFalse(battery.isFullyCharged());

		battery.markAsFullyCharged();
		assertTrue(battery.isFullyCharged());
	}

	@Test
	public void testMarkAsFullyCharged() {
		ReservedBattery battery = new ReservedBattery(789);
		assertFalse(battery.isFullyCharged());

		battery.markAsFullyCharged();
		assertTrue(battery.isFullyCharged());
	}

}
