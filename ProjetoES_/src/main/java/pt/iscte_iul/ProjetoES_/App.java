package pt.iscte_iul.ProjetoES_;

import java.util.List;

import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Board;
import org.trello4j.model.Card;



/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ){ 	   
        String trelloKey = "03a00a367901cc8e2cbd3a2e6270413c";
        String trelloAcessToken = "6e472de0607c15ac4429f146b7eee03ab057ca592890a435443a72a613e42b2e";
        Trello trelloApi = new TrelloImpl(trelloKey,trelloAcessToken);
        String nome_utilizador = "pedroduartecarrondoarsenio";
        List<Board> boards = trelloApi.getBoardsByMember(nome_utilizador);
        Board board = boards.get(0);
        String IdOrg = board.getIdOrganization();
        System.out.println("Nome do Projeto: "+ trelloApi.getOrganization(IdOrg).getDisplayName());
        List<Card> cards;
        	System.out.println("Nome do Board: "+ board.getName());
        	cards = trelloApi.getCardsByMember(nome_utilizador);
        	List<org.trello4j.model.List> list=trelloApi.getListByBoard(board.getId());
        	//System.out.println(cards);
        	System.out.println("Lista dos Cards:");
        	for(org.trello4j.model.List lista: list) {
        		System.out.println("\t"+lista.getName());
        	}
    }
}
