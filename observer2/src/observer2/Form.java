package observer2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Form extends JFrame {
	
	private Usuario usuario;
	
	public Form(Usuario usuario) {
		this.usuario = usuario;
		
		this.setLayout(new FlowLayout());
		this.setTitle("Usuario");
		
		this.getContentPane().add(new JLabel("Nome:"));
		
		JTextField input = new JTextField(30);
		this.getContentPane().add(input);
		
		JButton button = new JButton("update");
		this.getContentPane().add(button);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usuario.setNome(input.getText());
			}
		});
	}
	
	public void open() {
		this.pack();
		this.setVisible(true);
	}
	
}
