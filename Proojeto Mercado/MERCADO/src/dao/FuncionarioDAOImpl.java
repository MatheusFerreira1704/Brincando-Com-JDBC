package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entdidade.Funcionario;
import util.JdbcUtil;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	Funcionario funcionario = new Funcionario();

	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO FUNCIONARIO (NOME_FUNCIONARIO, SALARIO_FUNCIONARIO, ATIVO) VALUES (?, ?, ?, ?)";

		Connection conexao;

		try {
			// chamando a conex�o
			conexao = JdbcUtil.getConexao();
			// Preparando a comunica��o com o banco.
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, funcionario.getNomeFuncionaro());
			ps.setInt(2, funcionario.getSalarioFuncionaro());
			ps.setInt(3, funcionario.getSenhaFuncionario());
			ps.setString(4, "S");

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

		String sql = "UPDATE FUNCIONARIO SET NOME_FUNCIONARIO = ? ,  SENHA_FUNCIONARIO = ? WHERE ID_FUNCIONARIO = ? AND ATIVO = 'S'";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, funcionario.getNomeFuncionaro());
			// ps.setInt(2, funcionario.getSalarioFuncionaro());
			ps.setInt(2, funcionario.getSenhaFuncionario());
			ps.setInt(3, funcionario.getId_Funcionario());

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removerFuncionario(int id_Funcionario) {
		// TODO Auto-generated method stub

		String sql = "DELETE * FROM FUNCIONARIO WHERE ID_FUNCIONARIO = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id_Funcionario);

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Funcionario> pesquisarFuncionario(String nome) {

		String sql = "SELECT * FROM FUNCIONARIO WHERE NOME_FUNCIONARIO LIKE ? AND ATIVO = 'S' ";

		List<Funcionario> pesquisarFuncionario = new ArrayList<Funcionario>();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNomeFuncionaro(res.getString("NOME_FUNCIONARIO"));
				pesquisarFuncionario.add(funcionario);
			}

			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pesquisarFuncionario;
	}

	@Override
	public List<Funcionario> listarTodosFuncionarios() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM FUNCIONARIO";

		List<Funcionario> listarTodosFuncionarios = new ArrayList<Funcionario>();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId_Funcionario(res.getInt("ID_FUNCIONARIO"));
				funcionario.setNomeFuncionaro(res.getString("NOME_FUNCIONARIO"));
				listarTodosFuncionarios.add(funcionario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listarTodosFuncionarios;
	}

}
