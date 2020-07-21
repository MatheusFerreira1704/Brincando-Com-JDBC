package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entdidade.Produto;
import util.JdbcUtil;

public class ProdutoDAOImpl implements ProdutoDAO {

	Produto produto = new Produto();

	@Override
	public void inserirProduto(Produto produto) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PRODUTO (NOME_PRODUTO, QUANTIDADE, VALOR) VALUES (?,?,?)";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, produto.getNomeProduto());
			ps.setInt(2, produto.getQuantidade());
			ps.setInt(3, produto.getvalor());

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterarProduto(Produto produto) {
		// TODO Auto-generated method stub

		String sql = "UPDATE PRODUTO SET NOME_PRODUTO = ?, QUANTIDADE = ?, VALOR = ? WHERE ID_PRODUTO = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, produto.getNomeProduto());
			ps.setInt(2, produto.getQuantidade());
			ps.setInt(3, produto.getvalor());
			ps.setInt(4, produto.getId_Produto());

			ps.execute();
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerProduto(int id_Produto) {
		// TODO Auto-generated method stub

		String sql = "DELETE FROM PRODUTO WHERE ID_PRODUTO = ?";

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setInt(1, id_Produto);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> pesquisarProdutos(String nome) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM PRODUTO WHERE NOME_FUNCIONARIO LIKE ?";

		List<Produto> pesquisarProdutos = new ArrayList();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Produto produto = new Produto();
				produto.setNomeProduto(res.getString("NOME_PRODUTO"));
				produto.setQuantidade(res.getInt("QUANTIDADE"));
				produto.setvalor(res.getInt("VALOR"));
				pesquisarProdutos.add(produto);
			}
			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pesquisarProdutos;
	}

	@Override
	public List<Produto> listarProdutos() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUTO";

		List<Produto> listarProdutos = new ArrayList();

		Connection conexao;

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Produto produto = new Produto();
				produto.setNomeProduto(res.getString("NOME_PRODUTO"));
				produto.setQuantidade(res.getInt("QUANTIDADE"));
				produto.setvalor(res.getInt("VALOR"));
				listarProdutos.add(produto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listarProdutos;
	}

}
