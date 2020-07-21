package entdidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(generator = "S_PRODUTO")
	@SequenceGenerator(name = "S_PRODUTO", sequenceName = "S_PRODUTO", allocationSize = 1)
	@Column(name = "ID_PRODUTO")
	private int id_Produto;

	@Column(name = "NOME_PRODUTO")
	private String nomeProduto;

	@Column(name = "QUANTIDADE")
	private int quantidade;

	@Column(name = "VALOR")
	private int valor;

	public int getId_Produto() {
		return id_Produto;
	}

	public void setId_Produto(int id_Produto) {
		this.id_Produto = id_Produto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public int getvalor() {
		return valor;
	}

	public void setvalor(int valor) {
		valor = valor;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
