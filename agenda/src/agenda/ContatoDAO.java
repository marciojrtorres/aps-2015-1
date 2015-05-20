package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
}
