package entdidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(generator = "S_CLIENTE")
	@SequenceGenerator(name = "S_CLIENTE", sequenceName = "S_CLIENTE", allocationSize = 1)
	@Column(name = "ID_CLIENTE")
	private int id_cliente;

	@Column(name = "NOME_CLIENTE")
	private String nomeCliente;

	@Column(name = "SENHA")
	private int senha;

	@Column(name = "ATIVO")
	private String ativo;

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

}