package br.web.senai.produto;


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

import br.web.senai.produto.ProdutoDTO;

@RestController
@RequestMapping("/api/produto")
public final class ProdutoService {

	private final ProdutoController produtoController;

	ProdutoService(final ProdutoController produtoController) {
	    this.produtoController = produtoController;
	}

	@GetMapping("/lista")
	public List<ProdutoDTO> list() {
		return this.produtoController.getAllProdutos();
	}

	@GetMapping("/{id}/detalhes")
	public ResponseEntity<ProdutoDTO> getProduto(@PathVariable final Long id) {
		final ProdutoDTO produto = this.produtoController.getProduto(id);
		if (produto.equals(ProdutoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoDTO> removeProduto(@PathVariable final Long id) {
		final ProdutoDTO removedProduto = this.produtoController.removeProduto(id);
		if (removedProduto.equals(ProdutoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedProduto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable final Long id, @RequestBody final ProdutoDTO produto) {
		final ProdutoDTO oldProduto = this.produtoController.updateProduto(id, produto);
		if (oldProduto.equals(ProdutoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldProduto, HttpStatus.OK);
	}
					
	@PostMapping
	public Long insertProduto(@RequestBody final ProdutoDTO produto) {
		return this.produtoController.insertProduct(produto);
	}

}
