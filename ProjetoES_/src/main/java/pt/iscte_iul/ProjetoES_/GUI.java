package pt.iscte_iul.ProjetoES_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Class that creates the user interface.
 */

public class GUI implements ActionListener {
	
	private JButton button1,button2,button3,button4,button5,button6,button7;
	private JFrame frame=new JFrame();
	
	TrelloMethods trello = new TrelloMethods();
	GithubMethods github = new GithubMethods();
	
	/**
	 * Builds GUI.
	 * @throws java.io.IOException Throws IOException
	*/
	
	public GUI()  throws IOException{
		 
		 JPanel panel=new JPanel();
		
		  button1 = new JButton("Items em cada Sprint"); 
		  button1.addActionListener(this);
		  panel.add(button1); 
		  
		  button2 = new JButton("Conteúdo do README.md"); 
		  button2.addActionListener(this);
		  panel.add(button2); 
		  
		  button3 = new JButton("Nome do projeto");
		  button3.addActionListener(this);
		  panel.add(button3); 
		  
		  button4 = new JButton("Tags");
		  button4.addActionListener(this);
		  panel.add(button4);
		  
		  button5 = new JButton("Username dos membros do projeto");
		  button5.addActionListener(this);
		  panel.add(button5); 
		  
		  button6 = new JButton("Data do início do projeto");
		  button6.addActionListener(this);
		  panel.add(button6); 
		  
		  button7 = new JButton("Meeting Descriptions");
		  button7.addActionListener(this);
		  panel.add(button7);	 
		 
		  frame.add(panel, BorderLayout.CENTER);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setTitle("Interface Gráfica");
		  frame.pack();
		  frame.setVisible(true);	 
	}

	/**
	* Displays info in GUI when button is clicked
	* @param e button clicked.
	*/
	
	  public void actionPerformed(ActionEvent e){
		  
		  if (e.getSource() == button1){
			  JOptionPane.showMessageDialog(frame,"\tItems em cada Sprint:\n " + trello.getItemsDoneEachSprint());
			  }
		 
		 if (e.getSource() == button2){
			 try{
				 JOptionPane.showMessageDialog(frame,"\tConteúdo do README.md:\n" + github.getReadme()); 
				 } catch(IOException i) {
					 System.out.println("Error");
					 }
			 }
		 
		 if (e.getSource() == button3){
			 JOptionPane.showMessageDialog(frame,"\tNome do projeto:\n" + trello.getProjectID());
			 }
		 
		 if (e.getSource() == button4){
			 try{
				 JOptionPane.showMessageDialog(frame,"\tTags:\n" + github.getTags());
				 } catch(IOException i) {
					 System.out.println("Error");
					 }
			 }
		 
		 if (e.getSource() == button5){
			 JOptionPane.showMessageDialog(frame,"\tUsername dos membros:\n " + trello.getProjectMembers());
			 }
		 
		 if (e.getSource() == button6){
           JOptionPane.showMessageDialog(frame,"\tData do início do projeto:\n" + trello.getProjectStartDate());
           }
		 
		 if (e.getSource() == button7){
           JOptionPane.showMessageDialog(frame,"\tMeeting Descriptions:\n" + trello.getMeetingDescriptions());
           }
		
	 }
}