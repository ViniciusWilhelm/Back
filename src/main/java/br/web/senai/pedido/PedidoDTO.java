package br.web.senai.pedido;

public class PedidoDTO {
	
	public static final PedidoDTO NULL_VALUE = new PedidoDTO( null, "", "");
	private final Long id;
	private final String nome_pedido;
	private final String numero_pedido;
	
	
	
	public PedidoDTO(Long id, String nome_pedido, String numero_pedido) {
		
		this.id = id;
		this.nome_pedido = nome_pedido;
		this.numero_pedido = numero_pedido;
	}

	public Long getId() {
		return id;
	}

	public String getNome_pedido() {
		return nome_pedido;
	}

	public String getNumero_pedido() {
		return numero_pedido;
	}
	
	

}
