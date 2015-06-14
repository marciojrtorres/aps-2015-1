package observer2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FormAdicionaContato extends JFrame implements ActionListener {
	
	
	
	private JTextField nomeTextField = new JTextField(20);
	private JTextField telefoneTextField = new JTextField(10);
	
	public FormAdicionaContato() {
		
		this.setLayout(new FlowLayout());
		this.setTitle("Contato:Novo");
		
		this.getContentPane().add(new JLabel("Nome:"));
		this.getContentPane().add(nomeTextField);
		
		this.getContentPane().add(new JLabel("Telefone:"));
		this.getContentPane().add(telefoneTextField);
		
		JButton button = new JButton("Adiciona");
		this.getContentPane().add(button);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		button.addActionListener(this);
	}
	
	public void open() {
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Contato contato = new Contato();	
		contato.setNome(nomeTextField.getText());
		contato.setTelefone(telefoneTextField.getText());
		
		ContatoDAO.getInstance().insert(contato);
	}
}