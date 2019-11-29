package br.web.senai.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	
	@Entity(name = "Cliente")
	final class ClienteEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		private Long  id;
		
		private Long cpf;
		
		private String nome;
		
		private String telefone;
		
		private String email;
		
		
		public ClienteEntity(final Long id, final Long cpf,final String nome,final String telefone, final String email) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		
		}

		@Override
		public String toString() {
			return "ClienteEntity [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email="
					+ email + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getCpf() {
			return cpf;
		}

		public void setCpf(Long cpf) {
			this.cpf = cpf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		

}
