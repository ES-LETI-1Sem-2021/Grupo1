package pt.iscte_iul.ProjetoES_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GUI implements ActionListener {
	
	private JLabel label = new JLabel();
	private JButton button1,button2,button3,button4,button5,button6,button7;
	private JFrame frame=new JFrame();
	
	TrelloMethods trello = new TrelloMethods();
	GithubMethods github = new GithubMethods();
	
	public GUI()  throws IOException{
		
		 
		 JPanel panel=new JPanel();
		 System.out.println("passou pelo painel");
		
		  button1 = new JButton("Items done each Sprint");//mostar List<String> getItemsDoneEachSprint() 
		  button1.addActionListener(this);
		  panel.add(button1); 
		  System.out.println("criou botao 1");
		  
		  JButton button2 = new JButton("Read Me");//mostar String getReadme() 
		  button2.addActionListener(this);
		  panel.add(button2); 
		  
		  button3 = new JButton("Project ID");//mostar String getProjectID()
		  button3.addActionListener(this);
		  panel.add(button3); 
		  
		  JButton button4 = new JButton("Tags");//mostar List<String> getTags()
		  button4.addActionListener(this);
		  panel.add(button4);
		  
		  button5 = new JButton("Project Members");//mostar List<String> getProjectMembers() 
		  button5.addActionListener(this);
		  panel.add(button5); 
		  
		  button6 = new JButton("Project Start Date");//mostrar Date getProjectStartDate()
		  button6.addActionListener(this);
		  panel.add(button6); 
		  
		  button7 = new JButton("Meeting Descriptions");//mostrar List<String> getMeetingDescriptions()
		  button7.addActionListener(this);
		  panel.add(button7);	 
		 
		  frame.add(panel, BorderLayout.CENTER);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setTitle("Interface Gráfica");
		  frame.pack();
		  frame.setVisible(true);
		  
		
			 
	}
	
	
	
	public void aux(int i) throws IOException {
		 
		 if(i==0){
		 JOptionPane.showMessageDialog(frame,"\tConteúdo do README.md:\n" + github.getReadme());
	
		 }
		 
		 if(i==1){
		 JOptionPane.showMessageDialog(frame,"\tTags: " + github.getTags());
		 
		 }
		 
		
	}

	
	
	  public void actionPerformed(ActionEvent e){
		 
		 
		 if (e.getSource() == button1){
            JOptionPane.showMessageDialog(frame, "\tItems em cada Sprint: " + trello.getItemsDoneEachSprint());
       }
		 
		 if (e.getSource() == button2){
			 try{
			 aux(0);
			 } catch(IOException i) {
		         System.out.println("Error");
		    }
			   
      }
		 
		 if (e.getSource() == button3){
			JOptionPane.showMessageDialog(frame, "\tNome do projeto:\n" + trello.getProjectID());
       
      }
		 
		 if (e.getSource() == button4){
			 try{
				 aux(1);
				 } catch(IOException i) {
			         System.out.println("Error");
			    }
      }
		 
		 if (e.getSource() == button5){
           JOptionPane.showMessageDialog(frame, "\tUsername dos membros: " + trello.getProjectMembers());
      }
		 
		 if (e.getSource() == button6){
           JOptionPane.showMessageDialog(frame, "\tData do início do projeto:\n" + trello.getProjectStartDate());
      }
		 
		 if (e.getSource() == button7){
           JOptionPane.showMessageDialog(frame, "Meeting Descriptions: " + trello.getMeetingDescriptions());
      }
		 
		
	 }
}