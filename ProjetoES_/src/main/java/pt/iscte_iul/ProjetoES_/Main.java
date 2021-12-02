package pt.iscte_iul.ProjetoES_;

public class Main {

	public static void main(String[] args) {
		
		TrelloMethods trello = new TrelloMethods();
		
		System.out.println("\tNome do projeto:\n" + trello.getProjectID());
		
		System.out.println("\tNome dos membros:");
		for(String names : trello.getProjectMembers()) {
        	System.out.println(names);
        }
		
		for(String desc : trello.getMeetingDescriptions()) {
        	System.out.println("\t" + desc);
        }
		
		System.out.println("\tItems em cada Sprint:");
		for(String items : trello.getItemsDoneEachSprint()) {
        	System.out.println(items);
        }
	}
	
}
