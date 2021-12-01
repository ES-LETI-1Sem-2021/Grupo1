package pt.iscte_iul.ProjetoES_;

//import org.trello4j.model.Member;

public class Main {

	public static void main(String[] args) {
		TrelloMethods trello = new TrelloMethods();
		
		System.out.println("Nome do projeto: " + trello.getProjectID());
		
		System.out.println("Nome dos membros: ");
		for(String names : trello.getMembers()) {
        	System.out.println("\t"+ names);
        }
	}

}
