package pt.iscte_iul.ProjetoES_;

import java.util.List;
import java.util.ArrayList;
import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Board;
//import org.trello4j.model.Card;
import org.trello4j.model.Member;

public class TrelloMethods {
	
	String trelloKey = "03a00a367901cc8e2cbd3a2e6270413c";
	String trelloAcessToken = "6e472de0607c15ac4429f146b7eee03ab057ca592890a435443a72a613e42b2e";
	String nome_utilizador = "pedroduartecarrondoarsenio";
	Trello trelloApi = new TrelloImpl(trelloKey,trelloAcessToken);
	List<Board> boards = trelloApi.getBoardsByMember(nome_utilizador);
	Board board = boards.get(0);
	String boardID = board.getId();
	
	public String getProjectID() {
        String IdOrg = board.getIdOrganization();
        return trelloApi.getOrganization(IdOrg).getDisplayName();
	}
	
	public List <String> getMembers() {
		List<String> memberNames = new ArrayList<String>(); 
		List <Member> memberIDList = trelloApi.getMembersByBoard(boardID);
		for (int i = 0; i < memberIDList.size(); i++) {
			memberNames.add(memberIDList.get(i).getUsername());
		}
        return memberNames;
	}
        
    /**public void uselessForNow() {
     *  //get cards
        List<Card> cards = trelloApi.getCardsByMember(nome_utilizador);
        System.out.println("Nome do Board: "+ board.getName());
        List<org.trello4j.model.List> list=trelloApi.getListByBoard(board.getId());
        System.out.println(cards);
        System.out.println("Lista dos Cards:");
        for(org.trello4j.model.List lista : list) {
        	System.out.println("\t"+lista.getName());
        }
      
	}
	*/
}