package dao;

import java.util.List;

import entdidade.Produto;

public interface ProdutoDAO {

	public void inserirProduto(Produto produto);

	public void alterarProduto(Produto produto);

	public void removerProduto(int id_Produto);

	List<Produto> pesquisarProdutos(String nome);

	List<Produto> listarProdutos();

}