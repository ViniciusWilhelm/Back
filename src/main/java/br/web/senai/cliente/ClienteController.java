package br.web.senai.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;



@Controller
final class ClienteController {

	private final ClienteRepository clienteRepository;

	ClienteController(final ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	private static void updateEntityFromDTO(final ClienteDTO clienteDTO, final ClienteEntity clienteEntity) {
		clienteEntity.setCpf(clienteDTO.getCpf());
		clienteEntity.setEmail(clienteDTO.getEmail());
		clienteEntity.setId(clienteDTO.getId());
		clienteEntity.setNome(clienteDTO.getNome());
		clienteEntity.setTelefone(clienteDTO.getTelefone());
	}
	
	private static ClienteEntity toEntity(final ClienteDTO clienteDTO) {
		final Long id = clienteDTO.getCpf()
	}
	
}