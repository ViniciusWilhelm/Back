package br.web.senai.cliente;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.we.senai.cliente.ClienteController;
import br.we.senai.cliente.ClienteDTO;

@RestController
@RequestMapping("/api/cliente")
public final class ClienteService {

	private final ClienteController clienteController;

	ClienteService(final ClienteController clienteController) {
	    this.clienteController = clienteController;
	}

	@GetMapping("/lista_cliente")
	public List<ClienteDTO> list() {
		return this.clienteController.getAllClientes();
	}

	@GetMapping("/{id}/detalhes_cliente")
	public ResponseEntity<ClienteDTO> getCliente(@PathVariable final Long id) {
		final ClienteDTO cliente = this.clienteController.getCliente(id);
		if (cliente.equals(ClienteDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> removeCliente(@PathVariable final Long id) {
		final ClienteDTO removedCliente = this.clienteController.removeCliente(id);
		if (removedCliente.equals(ClienteDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedCliente, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable final Long id, @RequestBody final ClienteDTO cliente) {
		final ClienteDTO oldCliente = this.clienteController.updateCliente(id, cliente);
		if (oldCliente.equals(ClienteDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldCliente, HttpStatus.OK);
	}
					
	@PostMapping
	public Long insertCliente(@RequestBody final ClienteDTO cliente) {
		return this.clienteController.insertCliente(cliente);
	}

}
