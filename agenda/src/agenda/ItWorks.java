package agenda;

import java.sql.*;
import javax.sql.*;

public class ItWorks {

	public static void main(String[] args) {
		
		try {
			// todas as interfaces e classes tem de ser to java.jdbc

			String user = "root";
			String password = "root";
			// caminho do banco
			String url = "jdbc:mysql://localhost/agenda";
			// outro exemplo
			// String url = "jdbc:mysql://192.168.2.87/rh";
			
			// abrir a conexao
			Connection conexao = 
					DriverManager.getConnection(url, user, password);
			
			// comando
			String insert = "INSERT INTO contatos (nome, telefone) "
					      + "VALUES ('Vinicius', '32324455')";
					
			String delete = "DELETE FROM contatos WHERE id_contato = 2";
			// instrucao
			Statement instrucao = conexao.createStatement();
			
			// executa
			instrucao.execute(delete);
			
			// fecha conexao
			conexao.close();
			
			System.out.println("IT'S WORKS!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}