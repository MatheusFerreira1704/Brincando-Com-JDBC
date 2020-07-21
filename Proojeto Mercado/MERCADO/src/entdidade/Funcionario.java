package entdidade;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(generator = "S_FUNCIONARIO")
	@SequenceGenerator(name = "S_FUNCIONARIO", sequenceName = "S_FUNCIONARIO", allocationSize = 1)
	@Column(name = "ID_FUNCIONARIO")
	private int id_Funcionario;

	@Column(name = "NOME_FUNCIONARIO")
	private String nomeFuncionaro;

	@Column(name = "SALARIO_FUNCIONARIO")
	private int salarioFuncionaro;

	@Column(name = "SENHA_FUNCIONARIO")
	private int senhaFuncionario;

	@Column(name = "ATIVO")
	private String ativo;

	public int getId_Funcionario() {
		return id_Funcionario;
	}

	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}

	public int getSenhaFuncionario() {
		return senhaFuncionario;
	}

	public void setSenhaFuncionario(int senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}

	public String getNomeFuncionaro() {
		return nomeFuncionaro;
	}

	public void setNomeFuncionaro(String nomeFuncionaro) {
		this.nomeFuncionaro = nomeFuncionaro;
	}

	public int getSalarioFuncionaro() {
		return salarioFuncionaro;
	}

	public void setSalarioFuncionaro(int salarioFuncionaro) {
		this.salarioFuncionaro = salarioFuncionaro;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

}
