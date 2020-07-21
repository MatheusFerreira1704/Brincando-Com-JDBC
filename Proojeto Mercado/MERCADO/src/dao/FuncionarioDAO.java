package dao;

import java.util.List;

import entdidade.Funcionario;

public interface FuncionarioDAO {

	public void inserirFuncionario(Funcionario funcionario);

	public void alterarFuncionario(Funcionario funcionario);

	public void removerFuncionario(int id_Funcionario);

	List<Funcionario> pesquisarFuncionario(String nome);

	List<Funcionario> listarTodosFuncionarios();
}
