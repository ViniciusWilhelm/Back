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
		final Long cpf = clienteDTO.getCpf();
		final String email = clienteDTO.getEmail();
		final Long id = clienteDTO.getId();
		final String nome = clienteDTO.getNome();
		final String telefone = clienteDTO.getTelefone();
		return new ClienteEntity(id, cpf, nome, telefone, email);
		
	}
	
	
	private static ClienteDTO toDTO(ClienteEntity clienteEntity) {
		final Long cpf = clienteEntity.getCpf();
		final String email = clienteEntity.getEmail();
		final Long id = clienteEntity.getId();
		final String nome = clienteEntity.getNome();
		final String telefone = clienteEntity.getTelefone();
		return new ClienteDTO(id, cpf, nome, telefone, email);

	}
	
	
	List<ClienteDTO> getAllClientes() {
		final List<ClienteDTO> clientes = new ArrayList<>();
		this.clienteRepository.findAll().forEach(clienteEntity -> clientes.add(ClienteController.toDTO(clienteEntity)));
		return clientes;
	
	}
	
	ClienteDTO getCliente(final Long id) {
		final Optional<ClienteEntity> optionalCliente = this.clienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			return ClienteController.toDTO(optionalCliente.get());
		}
		return ClienteDTO.NULL_VALUE;
	}
	
	ClienteDTO removeCliente(final Long id) {
		final Optional<ClienteEntity> optionalCliente = this.clienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			final ClienteEntity clienteEntity = optionalCliente.get();
			this.clienteRepository.delete(clienteEntity);
			return ClienteController.toDTO(clienteEntity);
		}
		return ClienteDTO.NULL_VALUE;
	}
	
	Long insertcliente(final ClienteDTO clienteDTO) {
		final ClienteEntity clienteEntity = ClienteController.toEntity(clienteDTO);
		this.clienteRepository.save(clienteEntity);
		return clienteEntity.getId();
	}
	
	ClienteDTO updateCliente(final Long id, final ClienteDTO clienteDTO) {
		final Optional<ClienteEntity> optionalCliente = this.clienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			final ClienteEntity clienteEntity = optionalCliente.get();
			final ClienteDTO oldClienteDTO = ClienteController.toDTO(clienteEntity);
			ClienteController.updateEntityFromDTO(clienteDTO, clienteEntity);
			this.clienteRepository.save(clienteEntity);
			return oldClienteDTO;
		}
		return ClienteDTO.NULL_VALUE;
	}

}