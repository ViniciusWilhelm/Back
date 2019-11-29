package br.web.senai.cliente;

public class ClienteDTO {
	
	private final Long  id;
	private final Long cpf;
	private final String nome;
	private final String telefone;
	private final String email;
	
	public ClienteDTO(Long id, Long cpf, String nome, String telefone, String email) {
		
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
	
	
}

