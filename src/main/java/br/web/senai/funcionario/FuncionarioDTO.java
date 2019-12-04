package br.web.senai.funcionario;



public class FuncionarioDTO {
	
	public static final FuncionarioDTO NULL_VALUE = new FuncionarioDTO(Long.valueOf(0), "", "", "", Long.valueOf(0));
	private final Long id;
	private final String nome;
	private final String setor;
	private final String cargo;
	private final Long salario;
	
	public FuncionarioDTO(final Long id, final String nome, final String setor, final String cargo, final Long salario) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSetor() {
		return setor;
	}

	public String getCargo() {
		return cargo;
	}

	public Long getSalario() {
		return salario;
	}

	
}
