package observer2;

import javax.swing.*;

public class FormListaContatos extends JFrame {
	
	private ContatoDAO dao = ContatoDAO.getInstance();

	private JTextArea textArea = new JTextArea();

	public FormListaContatos() {
		this.setTitle("Contatos:Lista");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 200);		
		textArea.setMinimumSize(this.getSize());
		this.getContentPane().add(textArea);
		
		Contato contato1 = new Contato();
		contato1.setNome("IFRS");
		contato1.setTelefone("32338603");
		
		textArea.setText(contato1.getNome() 
				+ " " + contato1.getTelefone() + "\n");
	}

	public void open() {
		this.setVisible(true);
	}
}