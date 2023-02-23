package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {

	private Conexao con;

	// CRUD - C - CREATE
	public boolean inserir(Pessoa p) {

		// instanciar classe Conxao
		con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO pessoa" + "(cpf, nome) VALUES (?, ?);";
			PreparedStatement stm = c.prepareStatement(null);

			stm.setInt(1, 125);
			stm.setString(2, "Sofia");

			int valida = stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// fechar conexao
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Pessoa p) {
		Connection conn = Conexao.getInstancia().conectar();
		
		try {
			String query = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deletar(Pessoa p) {
		Connection con = Conexao.conectar();
		
		try {
			String query = "DELETE FROM pessoa WHERE cpf = ?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setLong(1, p.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Conexao.fecharConnection();
		return false;
	}

	// CRUD - R - READ
	public ArrayList<Pessoa> listarPessoas() {
	
		ArrayList<Pessoa>pessoas = new ArrayList<>();
		
		// instanciar classe Conxao
		con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();
		Connection c = con.conectar();
		try {

			Statement stm = c.prepareStatement(null);
			String query = "SELECT * FROM pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				pessoas.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// fechar conexao
		con.fecharConexao();
		return pessoas;
	}

}
