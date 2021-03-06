package dao;

import java.util.List;

import entdidade.Cliente;

public interface ClienteDAO {

	public void inserirCliente(Cliente cliente);
	
	public void alterarCliente(Cliente cliente);
	
	public void removerCliente(int id_cliente);
	
	List<Cliente> pesquisarCliente(String nome);
	
	List<Cliente> listarTodosClientes();
}
