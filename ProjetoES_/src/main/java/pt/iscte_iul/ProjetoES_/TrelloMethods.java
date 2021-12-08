package pt.iscte_iul.ProjetoES_;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Action;

/**
 * Class containing the methods that interact with Trello.
 */

public class TrelloMethods {
	
	private String trelloKey = "03a00a367901cc8e2cbd3a2e6270413c";
	private String trelloAcessToken = "6e472de0607c15ac4429f146b7eee03ab057ca592890a435443a72a613e42b2e";
	private String nome_utilizador = "pedroduartecarrondoarsenio";
	private Trello trelloApi = new TrelloImpl(trelloKey,trelloAcessToken);
	private List<Board> boards = trelloApi.getBoardsByMember(nome_utilizador);
	private Board board = boards.get(0);
	private String boardID = board.getId();
	private String orgID = board.getIdOrganization();
	private List<org.trello4j.model.List> lists = trelloApi.getListByBoard(boardID);
	
	/**
	 * Gets trello workspace name.
	 * @return project name
	 */
	
	public String getProjectID() {
        return trelloApi.getOrganization(orgID).getDisplayName();
	}
	
	/**
	 * Gets trello project member usernames.
	 * @return list of project members
	 */
	
	public List<String> getProjectMembers() {
		List<String> memberNames = new ArrayList<String>(); 
		List<Member> memberIDList = trelloApi.getMembersByBoard(boardID);
		for (int i = 0; i < memberIDList.size(); i++) {
			memberNames.add(memberIDList.get(i).getUsername());
		}
        return memberNames;
	}
	
	/**
	 * Gets date in which trello project was created.
	 * @return date of project creation
	 */
	
	public Date getProjectStartDate() {
		List<Date> dates = new ArrayList<Date>();
		List<Action> allActions = trelloApi.getActionsByOrganization(orgID);
		for (Action action : allActions) {
			dates.add(action.getDate());
		}
		dates.remove(0);
		return Collections.min(dates);
	}
	
	/**
	 * Gets a list with all meetings name and descriptions.
	 * @return list of descriptions
	 */
	
	public List<String> getMeetingDescriptions() {
		List<String> meetingsDesc = new ArrayList<String>();
		String meetingsListID = meetingsListID();
		List<Card> meetingCards = trelloApi.getCardsByList(meetingsListID);
        for (int i = 0; i < meetingCards.size(); i++) {
        	Card currentCard = meetingCards.get(i);
        	meetingsDesc.add(currentCard.getName() + ":\n" + currentCard.getDesc());
        }
        return meetingsDesc;
	}

	private String meetingsListID() {
		String meetingsListID = null;
		for (org.trello4j.model.List list : lists) {
			if (list.getName().contentEquals("Sprint Planning / Review / Retrospective")) {
				meetingsListID = list.getId();
			}
		}
		return meetingsListID;
	}
	
	/**
	 * Gets a list of done card titles followed by the sprint they were completed on.
	 * @return list of card name and respective sprint 
	 */
	
	public List<String> getItemsDoneEachSprint() {
		List<String> itemsSprint = new ArrayList<String>();
		String doneListID = doneListID("Done");
		List<Card> doneCards = trelloApi.getCardsByList(doneListID);
		for (int i = 0; i < doneCards.size(); i++) {
			Card card = doneCards.get(i);
			for (int y = 0; y < card.getLabels().size(); y++) {
				String labelName = card.getLabels().get(y).getName();
				if (labelName.contains("Sprint")) {
					itemsSprint.add(card.getName() + " -> " + labelName);
				}
			}
		}
		return itemsSprint;
	}

	private String doneListID(String name) {
		String doneListID = null;
		for (org.trello4j.model.List list : lists) {
			if (list.getName().contentEquals(name)) {
				doneListID = list.getId();
			}
		}
		return doneListID;
	}
	
	/**
	 * Gets date of start and end of sprints.
	 * @return list of start and end of all sprints
	 */
	
	public List<String> getSprintsDates() {
		List<String> itemsSprint = new ArrayList<String>();
		String doneListID = doneListID("Sprint");
		String nameComplete=null;
		String dateOfSprint=null;
		String numberOfSprint=null;
		List<Card> doneCards = trelloApi.getCardsByList(doneListID);
		for (int i = 0; i < doneCards.size(); i++) {
			dateOfSprint = dateOfSprint(nameComplete, dateOfSprint, doneCards, i);
			numberOfSprint = numberOfSprint(nameComplete, numberOfSprint, doneCards, i);
			nameComplete = nameComplete(nameComplete, doneCards, i);
			itemsSprint.add(numberOfSprint+"->"+dateOfSprint);
		}
		return itemsSprint;
	}

	private String numberOfSprint(String nameComplete, String numberOfSprint, List<Card> doneCards, int i) {
		nameComplete = nameComplete(nameComplete, doneCards, i);
		numberOfSprint = nameComplete.substring(0, nameComplete.indexOf(":"));
		System.out.println("numberOfSprint: " + numberOfSprint);
		return numberOfSprint;
	}

	private String dateOfSprint(String nameComplete, String dateOfSprint, List<Card> doneCards, int i) {
		nameComplete = nameComplete(nameComplete, doneCards, i);
		dateOfSprint = nameComplete.substring(nameComplete.indexOf(":") + 1);
		System.out.println("dateOfSprint: " + dateOfSprint);
		return dateOfSprint;
	}
	
	private String nameComplete(String nameComplete, List<Card> doneCards, int i) {
		Card card = doneCards.get(i);
		nameComplete = card.getName();
		System.out.println("nameComplete: " + nameComplete);
		return nameComplete;
	}
		
}