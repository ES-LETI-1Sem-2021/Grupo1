package pt.iscte_iul.ProjetoES_;

import pt.iscte_iul.ProjetoES_.GithubMethods;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class for testing methods that interact with GitHub.
 */

public class GithubMethodsTest {
	
	GithubMethods github = new GithubMethods();
	
	public GithubMethodsTest() throws IOException {
	}

	@Test
	public void test() throws Exception {
		Assert.assertNotNull(github);
		Assert.assertNotNull(github.getReadme());
		Assert.assertNotNull(github.getTags());
	}

}
