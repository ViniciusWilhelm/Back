package br.web.senai.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import br.web.senai.pedido.PedidoController;
import br.web.senai.pedido.PedidoDTO;
import br.web.senai.pedido.PedidoEntity;

@Controller
final class PedidoController {

	private final PedidoRepository pedidoRepository;
	
	public PedidoController( final PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	private static void updateEntityFromDTO( final PedidoDTO pedidoDTO, final PedidoEntity pedidoEntity) {
		pedidoEntity.setId(pedidoDTO.getId());
		pedidoEntity.setNome_pedido(pedidoDTO.getNome_pedido());
		pedidoEntity.setNumero_pedido(pedidoDTO.getNumero_pedido());
		
	}
	
	private static PedidoEntity toEntity(final PedidoDTO pedidoDTO) {
		final Long id = pedidoDTO.getId();
		final String nome = pedidoDTO.getNome_pedido();
		final String numero= pedidoDTO.getNumero_pedido();
		return new PedidoEntity(id, nome, numero);
	}

	public List<PedidoDTO> getAllPedidos() {
		final List<PedidoDTO> pedidos = new ArrayList<>();
		this.pedidoRepository.findAll().forEach(pedidoEntity -> pedidos.add(PedidoController.toDTO(pedidoEntity)));
		return pedidos;
	}
	
	private static PedidoDTO toDTO(final PedidoEntity pedidoEntity) {
		final Long id = pedidoEntity.getId();
		final String nome_pedido = pedidoEntity.getNome_pedido();
		final String numero_pedido = pedidoEntity.getNumero_pedido();
		return new PedidoDTO(id, nome_pedido, numero_pedido);
	}

	PedidoDTO removePedido( final Long id) {
		final Optional <PedidoEntity> optionalPedido = this.pedidoRepository.findById(id);
		if (optionalPedido.isPresent()) {
			final PedidoEntity pedidoEntity = optionalPedido.get();
			this.pedidoRepository.delete(pedidoEntity);
			return PedidoController.toDTO(pedidoEntity);
		}
		return (PedidoDTO) PedidoDTO.NULL_VALUE;
	}

	PedidoDTO getPedido(final Long id) {
		final Optional<PedidoEntity> optionalPedido = this.pedidoRepository.findById(id);
		if (optionalPedido.isPresent()) {
			return PedidoController.toDTO(optionalPedido.get());
		}
		return PedidoDTO.NULL_VALUE;
	}
	
	Long insertPedido(final PedidoDTO pedidoDTO) {
		final PedidoEntity pedidoEntity = PedidoController.toEntity(pedidoDTO);
		this.pedidoRepository.save(pedidoEntity);
		return pedidoEntity.getId();
	}

	PedidoDTO updatePedido(final Long id, final PedidoDTO pedidoDTO) {
		final Optional<PedidoEntity> optionalPedido= this.pedidoRepository.findById(id);
		if (optionalPedido.isPresent()) {
			final PedidoEntity pedidoEntity = optionalPedido.get();
			final PedidoDTO oldPedidoDTO = PedidoController.toDTO(pedidoEntity);
			PedidoController.updateEntityFromDTO(pedidoDTO, pedidoEntity);
			this.pedidoRepository.save(pedidoEntity);
			return oldPedidoDTO;
		}
		return PedidoDTO.NULL_VALUE;
	}

	

	
}
	
	