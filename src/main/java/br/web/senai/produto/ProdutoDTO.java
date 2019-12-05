package br.web.senai.produto;

public class ProdutoDTO {
	
	public static final ProdutoDTO NULL_VALUE = new ProdutoDTO( null, "", "", "");
	
	private final Long id;
	private final String nome;
	private final String descricao;
	private final String preco;
	
	public ProdutoDTO (final Long id, final String nome, final String descricao, final String preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;

	}

	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getPreco() {
		return preco;
	}
	
}
