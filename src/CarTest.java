import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	public void testGetName() {
		Car car = new Car("Toyota", 10);
		assertEquals("Toyota", car.getName());
	}

	@Test
	public void testGetMaxWaitTime() {
		Car car = new Car("Toyota", 10);
		assertEquals(10, car.getMaxWaitTime());
	}
}
