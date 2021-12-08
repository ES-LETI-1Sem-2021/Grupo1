package pt.iscte_iul.ProjetoES_;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class for testing user interface.
 */

public class GUITest {
	
	GUI gui = new GUI();
	
	public GUITest() throws IOException {
	}

	@Test
	public void test() {
		Assert.assertNotNull(gui);
	}

}
