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

		con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "INSERT INTO pessoa" + "(cpf, nome) VALUES (?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setInt(1, 125);
			stm.setString(2, "Sofia");
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

	public boolean alterar(Pessoa p) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

	public boolean deletar(Pessoa p) {
		con = Conexao.getInstancia();
		Connection c = con.conectar();

		try {
			String query = "DELETE FROM pessoa WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, p.getCpf());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

	// CRUD - R - READ
	public ArrayList<Pessoa> listarPessoas() {

		ArrayList<Pessoa> pessoas = new ArrayList<>();

		con = Conexao.getInstancia();
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
		} finally {
			con.fecharConexao();
		}

		return pessoas;
	}

}
