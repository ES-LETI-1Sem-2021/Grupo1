package pt.iscte_iul.ProjetoES_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
	private JLabel nomeGrupo =new JLabel("label");
	private JLabel elementos =new JLabel("label");
	private JFrame frame = new JFrame();
	

	public GUI(){
		JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(nomeGrupo);
        panel.add(elementos);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
	}

	public void projectName(String name,String elementosGR) {
		
		nomeGrupo.setText("project Name: " + name);
		elementos.setText( "Elementos do grupo:" + elementosGR);
	}
}