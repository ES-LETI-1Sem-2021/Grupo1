package pt.iscte_iul.ProjetoES_;

import pt.iscte_iul.ProjetoES_.GithubMethods;
import java.io.IOException;
import org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;

public class GithubMethodsTest {
	
	GithubMethods github = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GithubMethods github = new GithubMethods();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Assert.assertNull(github);
	}

}
