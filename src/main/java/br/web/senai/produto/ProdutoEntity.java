package br.web.senai.produto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Produto")
final class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	
	private String nome;

	private String descricao;

	private String preco;
	
	
	protected ProdutoEntity() {
	}

	public ProdutoEntity(final Long id, final String nome, final String descricao, final String preco) {
		this.id = id;
		this.nome = nome;
		this.descricao= descricao;
		this.preco = preco;
	}
	
	

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
}