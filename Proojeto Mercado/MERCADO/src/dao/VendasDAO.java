package dao;

import java.util.List;

import entdidade.Vendas;

public interface VendasDAO {

	public void iserirVendas(Vendas vendas);

	public void removerVendas(int id_Vendas);

	List<Vendas> listarVendas();

}
