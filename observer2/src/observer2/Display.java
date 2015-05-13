package observer2;

import java.awt.FlowLayout;

import javax.swing.*;

public class Display extends JFrame {
	
	private JLabel label = new JLabel();
	private Usuario usuario;

	public Display(Usuario usuario) {
		this.usuario = usuario;
		
		this.setLayout(new FlowLayout());
		
		this.setTitle("Login");		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(200, 40);
		this.setAlwaysOnTop(true);
		
		if (usuario.getNome().isEmpty()) {
			label.setText("não logado");
		} else {
			label.setText("logado como " + usuario.getNome());
		}
		
		this.getContentPane().add(label);
		this.setUndecorated(true);
		this.setOpacity(0.9f);
	}
	
	public void open() {
		this.setVisible(true);
	}
}