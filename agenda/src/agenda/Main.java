package agenda;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// lidar com fonte de dados
		// costuma-se abstrair: existem Padrões de Arquitetura
		// Banco: agenda
		// Tabela: contatos
		// Abstrair a conexão e manipulação do banco: DAO
		// Mapeamento Objeto/Relacional
		// ORM (Object Relational Mapping)
		
		// SCHEMA FIRST OU MODEL FIRST
		
		Contato alex = new Contato();
		alex.setNome("Alex");
		alex.setSobrenome("Mirapalheta");
		alex.setTelefone("88665522");
		
		// contato antes de ser persistido
		System.out.println(alex);
		
		ContatoDAO dao = new ContatoDAO();
		// método que faz a inserção
		// opções de nomes:
		// dao.save(alex);
		dao.insert(alex);
		// dao.persist(alex);
		// dao.create(alex);
		
		// contato depois de ser persistido
		System.out.println(alex);		
		
		// API da busca:
		List<Contato> contatos = dao.select();
		// dao.findAll();
		// dao.busca();
		// dao.search();
		// dao.readAll();
		for (Contato c : contatos) {
			System.out.println(c);
		}
		
		Contato teste = contatos.get(0);
		
		teste.setTelefone("32445522");
		
		dao.update(teste);
		
		dao.delete(contatos.get(1));
		
		
		

	}

}
