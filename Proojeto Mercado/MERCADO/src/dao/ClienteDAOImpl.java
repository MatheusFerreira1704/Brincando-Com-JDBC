package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entdidade.Cliente;
import util.JdbcUtil;

public class ClienteDAOImpl implements ClienteDAO {

	// Inst�nciando cliente
	Cliente cliente = new Cliente();

	@Override
	public void inserirCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CLIENTE (NOME_CLIENTE, SENHA, ATIVO) VALUES (?,?,?)";

		Connection conexao;

		try {

			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setInt(2, cliente.getSenha());
			ps.setString(3, "S");

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CLIENTE SET NOME_CLIENTE = ?, SENHA = ? WHERE ID_CLIENTE= ? AND ATIVO = 'S'";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setInt(2, cliente.getSenha());
			ps.setInt(3, cliente.getId_cliente());

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerCliente(int id_cliente) {
		// TODO Auto-generated method stub

		String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id_cliente);
			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Cliente> pesquisarCliente(String nome) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ? AND ATIVO ='S'";

		List<Cliente> pesquisarCliente = new ArrayList<Cliente>();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Cliente cliente = new Cliente();
				// cliente.setId_cliente(res.getInt("ID_CLIENTE"));
				cliente.setNomeCliente(res.getString("NOME_CLIENTE"));
				pesquisarCliente.add(cliente);
			}
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pesquisarCliente;
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM CLIENTE WHERE ATIVO = 'S'";

		List<Cliente> listarTodosClientes = new ArrayList<Cliente>();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(res.getInt("ID_CLIENTE"));
				cliente.setNomeCliente(res.getString("NOME_CLIENTE"));
				listarTodosClientes.add(cliente);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarTodosClientes;
	}

}