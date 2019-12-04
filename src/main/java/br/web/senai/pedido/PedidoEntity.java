package br.web.senai.pedido;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Pedido")
final class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private  Long id;
	
	private  String nome_pedido;
	
	private  String numero_pedido;
	
	
	protected PedidoEntity () {
	}
	
		public PedidoEntity(final Long id, final String nome_pedido, final String numero_pedido) {
			this.id = id;
			this.nome_pedido = nome_pedido;
			this.numero_pedido = numero_pedido;
	}

		@Override
		public String toString() {
			return "PedidoEntity [id=" + id + ", nome_pedido=" + nome_pedido + ", numero_pedido=" + numero_pedido + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome_pedido() {
			return nome_pedido;
		}

		public void setNome_pedido(String nome_pedido) {
			this.nome_pedido = nome_pedido;
		}

		public String getNumero_pedido() {
			return numero_pedido;
		}

		public void setNumero_pedido(String numero_pedido) {
			this.numero_pedido = numero_pedido;
		}
		
		

		
}
