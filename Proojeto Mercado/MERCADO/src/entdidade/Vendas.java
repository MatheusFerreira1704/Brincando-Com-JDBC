package entdidade;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "VENDAS")
public class Vendas {

	@Id
	@GeneratedValue(generator = "S_VENDAS")
	@SequenceGenerator(name = "S_VENDAS", sequenceName = "S_VENDAS", allocationSize = 1)
	private int id_Vendas;

	@Column(name = "ID_CLIENTE")
	private int id_Cliente;

	@Column(name = "ID_PRODUTO")
	private int id_Produto;

	@Column(name = "ID_FUNCIONARIO")
	private int id_Funcionario;

	public int getId_Vendas() {
		return id_Vendas;
	}

	public void setId_Vendas(int id_Vendas) {
		this.id_Vendas = id_Vendas;
	}

	public int getId_Cliente() {
		return id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}

	public int getId_Produto() {
		return id_Produto;
	}

	public void setId_Produto(int id_Produto) {
		this.id_Produto = id_Produto;
	}

	public int getId_Funcionario() {
		return id_Funcionario;
	}

	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}

	
}
