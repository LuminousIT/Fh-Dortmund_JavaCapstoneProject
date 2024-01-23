import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserTest {

	@Test
    public void testGetFullname() {
        User user = new User("John Doe",  "SUV");
        assertEquals("John Doe", user.getFullname());
    }

    @Test
    public void testGetCarType() {
        User user = new User("John Doe", "SUV");
        assertEquals("SUV", user.getCarType());
    }

 
    @Test
    public void testSetFullname() {
        User user = new User("John Doe",  "SUV");
        user.setFullname("Jane Smith");
        assertEquals("Jane Smith", user.getFullname());
    }

    @Test
    public void testSetCarType() {
        User user = new User("John Doe",  "SUV");
        user.setCarType("Sedan");
        assertEquals("Sedan", user.getCarType());
    }

   
}
