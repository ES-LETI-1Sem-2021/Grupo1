package pt.iscte_iul.ProjetoES_;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class for testing methods that interact with Trello.
 */

public class TrelloMethodsTest {

	@Test
	public void test() {
		TrelloMethods trello = new TrelloMethods();
        Assert.assertNotNull(trello);
        Assert.assertNotNull(trello.getProjectID());
        Assert.assertNotNull(trello.getProjectMembers());
        Assert.assertNotNull(trello.getItemsDoneEachSprint());
        Assert.assertNotNull(trello.getMeetingDescriptions());
        Assert.assertNotNull(trello.getSprintsDates());
        Assert.assertNotNull(trello.getProjectStartDate());
	}

}
