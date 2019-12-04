package br.web.senai.funcionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Funcionario")
public class FuncionarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String nome;
	private String setor;
	private String cargo;
	private Long salario;
	
	protected FuncionarioEntity () {
	}
	
	
	public FuncionarioEntity(final Long id, final String nome, final String setor, final String cargo, final Long salario) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
		this.cargo = cargo;
		this.salario = salario; 
	}


	@Override
	public String toString() {
		return "FuncionarioEntity [id=" + id + ", nome=" + nome + ", setor=" + setor + ", cargo=" + cargo + ", salario="
				+ salario + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Long getSalario() {
		return salario;
	}


	public void setSalario(Long salario) {
		this.salario = salario;
	}
	
}