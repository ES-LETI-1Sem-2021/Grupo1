package pt.iscte_iul.ProjetoES_;

import java.util.List;
import java.util.ArrayList;
import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;

public class TrelloMethods {
	
	String trelloKey = "03a00a367901cc8e2cbd3a2e6270413c";
	String trelloAcessToken = "6e472de0607c15ac4429f146b7eee03ab057ca592890a435443a72a613e42b2e";
	String nome_utilizador = "pedroduartecarrondoarsenio";
	Trello trelloApi = new TrelloImpl(trelloKey,trelloAcessToken);
	List<Board> boards = trelloApi.getBoardsByMember(nome_utilizador);
	Board board = boards.get(0);
	String boardID = board.getId();
	List<org.trello4j.model.List> lists = trelloApi.getListByBoard(boardID);
	
	public String getProjectID() {
        String IdOrg = board.getIdOrganization();
        return trelloApi.getOrganization(IdOrg).getDisplayName();
	}
	
	public List<String> getProjectMembers() {
		List<String> memberNames = new ArrayList<String>(); 
		List<Member> memberIDList = trelloApi.getMembersByBoard(boardID);
		for (int i = 0; i < memberIDList.size(); i++) {
			memberNames.add(memberIDList.get(i).getUsername());
		}
        return memberNames;
	}
	
	//public Card getProjectStartDate() {
		//return trelloApi.getCardsByList(lists.get(0).getId()).get(0);
		// ainda por fazer!
	//}
	
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