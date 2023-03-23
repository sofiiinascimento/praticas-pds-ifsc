package exc8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CriaBanco {
	
	public static void main(String[] args) {
	
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/","root","8-EeP&;ZIX");
			Statement stm = conexao.createStatement();
			String WSQL = "create database baquinhodasofi;";
			stm.executeUpdate(WSQL);
			
			WSQL = "USE baquinhodasofi;";
			stm.executeUpdate(WSQL);
			
			String query = "create table pessoas(cpf long PRIMARY KEY, nome varchar(255) NOT NULL, email varchar(255) NOT NULL);";
			stm.executeUpdate(query);
			
			conexao.close();
			System.out.println("Você conseguiu criar o BANQUINDO DA SOFI :)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
