package br.web.senai.pedido;
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

import br.web.senai.pedido.PedidoDTO;
import br.web.senai.pedido.PedidoController;



@RestController
@RequestMapping("/api/pedido")
public class PedidoService {
	
	private final PedidoController pedidoController;

	PedidoService(final PedidoController pedidoController) {
	    this.pedidoController = pedidoController;
	}
	
	@GetMapping("/lista_pedido")
	public List<PedidoDTO> list() {
		return this.pedidoController.getAllPedidos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> getPedido(@PathVariable final Long id) {
		final PedidoDTO pedido = this.pedidoController.getPedido(id);
		if (pedido.equals(PedidoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pedido, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PedidoDTO> removePedido(@PathVariable final Long id) {
		final PedidoDTO removedPedido= this.pedidoController.removePedido(id);
		if (removedPedido.equals(PedidoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedPedido, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoDTO> updatePedido(@PathVariable final Long id, @RequestBody final PedidoDTO pedido) {
		final PedidoDTO oldPedido = this.pedidoController.updatePedido(id, pedido);
		if (oldPedido.equals(PedidoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldPedido, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertPedido(@RequestBody final PedidoDTO pedido) {
		return this.pedidoController.insertPedido(pedido);
	}

}
