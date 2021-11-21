package pt.iscte_iul.ProjetoES;
import java.util.List;
import com.julienvey.trello.impl.http.ApacheHttpClient;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.domain.TList;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.Trello;

public class App 
{
    public static void main (String[] args) {
        String trelloKey="Key_utilizador";
        String trelloAccessToken="Token_utilizador";
        Trello trelloApi = new TrelloImpl(trelloKey, trelloAccessToken, new ApacheHttpClient());
        Board board;
        List<Board> member=trelloApi.getMemberBoards("nome_utilizador"); //podem consultar o vosso nome_utilizador na opção "profile and visibility" da vossa conta no trello
        
        for (Board  quadro: member) {
            System.out.println(quadro.getName()+ "-" +quadro.getId());
            board = trelloApi.getBoard(quadro.getId());
            List<TList> lists = board.fetchLists();
            for (TList lista : lists) {
                System.out.println(lista.getName()+"- "+ lista.getId()+"-"+lista.getIdBoard());
            }
        }

    }
}
