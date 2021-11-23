package pt.iscte_iul.ProjetoES_;

import java.util.List;

import org.trello4j.Trello;
import org.trello4j.TrelloImpl;
import org.trello4j.model.Board;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String trelloKey = "e9ce836fb30a14586c6b47cb5de0c08f";
        String trelloAcessToken="32123daef3beb3b117540a482a6a889bf57b4586963251423a58ec8deee0d74";
        Trello trelloApi= new TrelloImpl(trelloKey,trelloAcessToken);
        Board board;
        String nome_utilizador="margaridaneves3";
        List<Board> member=trelloApi.getBoardsByMember(nome_utilizador);
        for(Board quadro: member) {
        	System.out.println(quadro.getName()+ "-" +quadro.getId());
        	board=trelloApi.getBoard(quadro.getId());
        	List<List> lists=board.fetchLists();
        	for(TList lista: lists) {
        		System.out.println(lista.getName()+ "-" +lista.getId()+ "-" +lista.getIdBoard());
        	}
        }
    }
}
