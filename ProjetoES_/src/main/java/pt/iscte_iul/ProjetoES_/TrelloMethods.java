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
	
	
	public String getProjectID() {
        return trelloApi.getOrganization(orgID).getDisplayName();
	}
	
	public List<String> getProjectMembers() {
		List<String> memberNames = new ArrayList<String>(); 
		List<Member> memberIDList = trelloApi.getMembersByBoard(boardID);
		for (int i = 0; i < memberIDList.size(); i++) {
			memberNames.add(memberIDList.get(i).getUsername());
		}
        return memberNames;
	}
	
	public Date getProjectStartDate() {
		List<Date> dates = new ArrayList<Date>();
		List<Action> allActions = trelloApi.getActionsByOrganization(orgID);
		for (Action action : allActions) {
			dates.add(action.getDate());
		}
		dates.remove(0);
		return Collections.min(dates);
	}
	
	public List<String> getMeetingDescriptions() {
		List<String> meetingsDesc = new ArrayList<String>();
		String meetingsListID = null;
        for (org.trello4j.model.List list : lists) {
        	if (list.getName().contentEquals("Sprint Planning / Review / Retrospective")) {
        		meetingsListID = list.getId();
        	}
        }
        List<Card> meetingCards = trelloApi.getCardsByList(meetingsListID);
        for (int i = 0; i < meetingCards.size(); i++) {
        	Card currentCard = meetingCards.get(i);
        	meetingsDesc.add(currentCard.getName() + ":\n" + currentCard.getDesc());
        }
        return meetingsDesc;
	}
	
	public List<String> getItemsDoneEachSprint() {
		List<String> itemsSprint = new ArrayList<String>();
		String doneListID = null;
		for (org.trello4j.model.List list : lists) {
        	if (list.getName().contentEquals("Done")) {
        		doneListID = list.getId();
        	}	
        }
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
		
}