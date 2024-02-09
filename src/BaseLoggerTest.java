import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseLoggerTest {

	@Test
	public void testLog() {
	
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		BaseLogger baseLogger = new BaseLogger();
		baseLogger.log("Test log message");


		assertEquals("Test log message\n", outputStreamCaptor.toString());
	}

	@Test
	public void testLogActivity() {
		// Redirect System.out to capture printed output
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		BaseLogger baseLogger = new BaseLogger();
		baseLogger.logActivity("Test log activity message");

		// Verify the output using assertEquals
		assertEquals("Test log activity message\n", outputStreamCaptor.toString());
	}

}
