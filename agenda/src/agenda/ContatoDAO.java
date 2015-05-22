package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	
	private static final String user = "root";
	private static final String password = "root";	
	private static final String url = "jdbc:mysql://localhost/agenda";
	
	public void insert(Contato contato) {
		try {			
			Connection conexao = 
					DriverManager.getConnection(url, user, password);
			
			// NÃO FACA ISSO! NUNCA CONCATENE OS PARAMETROS
			// VULNERAVEL A SQL INJECTION
			// String insert = "INSERT INTO contatos (nome, telefone) VALUES ('" + contato.getNome() + "', '32324455')";
			// COMANDOS DEVEM SER ESCAPADOS O\'BRIAN
			// QUERIES PARAMETRIZADAS					
			// Statement instrucao = conexao.createStatement();
																				
			String insert = "INSERT INTO contatos "
						  + "(nome, sobrenome, telefone) "
					      + "VALUES (?, ?, ?);";
			
			PreparedStatement instrucao = conexao.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			
			instrucao.setString(1, contato.getNome());
			instrucao.setString(2, contato.getSobrenome());
			instrucao.setString(3, contato.getTelefone());
			
			instrucao.executeUpdate();
			
			ResultSet result = instrucao.getGeneratedKeys();
			
			if (result.next()) contato.setId(result.getInt(1));
			
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public List<Contato> select() {
		List<Contato> lista = new ArrayList<Contato>();
		
		// fazer um query para preencher a lista
		try {			
			Connection conexao = 
					DriverManager.getConnection(url, user, password);
			
			String select = "SELECT * FROM contatos";
			
			Statement instrucao = conexao.createStatement();
			
			ResultSet result = instrucao.executeQuery(select);
			
			// result é um iterador sobre um "ponteiro" de registro
			while (result.next()) {
				Contato c = new Contato();
				c.setId(result.getInt("id_contato"));
				c.setNome(result.getString("nome"));
				c.setSobrenome(result.getString("sobrenome"));
				c.setTelefone(result.getString("telefone"));
				lista.add(c);
			}
			
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}


	public void update(Contato contato) {
		try {			
			Connection conexao = 
					DriverManager.getConnection(url, user, password);
																					
			String update = "UPDATE contatos "
						  + "SET nome = ?, sobrenome = ?, telefone= ? "
					      + "WHERE id_contato = ?";
			
			PreparedStatement instrucao = conexao.prepareStatement(update);
			
			instrucao.setString(1, contato.getNome());
			instrucao.setString(2, contato.getSobrenome());
			instrucao.setString(3, contato.getTelefone());
			instrucao.setInt(4, contato.getId());
			
			instrucao.executeUpdate();
			
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void delete(Contato contato) {
		try {			
			Connection conexao = 
					DriverManager.getConnection(url, user, password);
																					
			String delete = "DELETE FROM contatos "
					      + "WHERE id_contato = ?";
			
			PreparedStatement instrucao = conexao.prepareStatement(delete);
			
			instrucao.setInt(1, contato.getId());
			
			instrucao.executeUpdate();
			
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}