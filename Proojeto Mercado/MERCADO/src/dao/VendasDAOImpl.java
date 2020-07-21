package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entdidade.Vendas;
import util.JdbcUtil;

public class VendasDAOImpl implements VendasDAO {

	Vendas vendas = new Vendas();

	@Override
	public void iserirVendas(Vendas vendas) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO VENDAS(ID_CLIENTE,ID_PRODUTO,ID_FUNCIONARIO) VALUES (?,?,?);";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, vendas.getId_Cliente());
			ps.setInt(2, vendas.getId_Produto());
			ps.setInt(3, vendas.getId_Funcionario());

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerVendas(int id_Vendas) {
		// TODO Auto-generated method stub

		String sql = "DELETE FROM VENDAS WHERE ID_VENDAS = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id_Vendas);

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Vendas> listarVendas() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM VENDAS";

		List<Vendas> listarVendas = new ArrayList();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Vendas vendas = new Vendas();
				vendas.setId_Cliente(res.getInt("ID_CLIENTE"));
				vendas.setId_Produto(res.getInt("ID_PRODUTO"));
				vendas.setId_Funcionario(res.getInt("ID_FUNCIONARIO"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listarVendas;
	}

}
