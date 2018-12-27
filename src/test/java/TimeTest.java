import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Time;

public class TimeTest {

	@Test
	public void test() {
		Time time = new Time();
		int x = time.generateRandomTime();
		if(x >= 0 && x <= 3000) {
			assertEquals(true, true);
		}else {
			assertEquals(true, false);
		}
	}

}
