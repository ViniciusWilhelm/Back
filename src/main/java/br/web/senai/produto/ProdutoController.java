package br.web.senai.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
final class ProdutoController {

	private final ProdutoRepository produtoRepository;

	ProdutoController(final ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	private static void updateEntityFromDTO(final ProdutoDTO produtoDTO, final ProdutoEntity produtoEntity) {
		produtoEntity.setId(produtoDTO.getId());
		produtoEntity.setNome(produtoDTO.getNome());
		produtoEntity.setDescricao(produtoDTO.getDescricao());
		produtoEntity.setPreco(produtoDTO.getPreco());
	}

	private static ProdutoEntity toEntity(final ProdutoDTO produtoDTO) {
		final Long id = produtoDTO.getId();
		final String nome = produtoDTO.getNome();
		final String descricao= produtoDTO.getDescricao();
		final String preco = produtoDTO.getPreco();
		return new ProdutoEntity(id, nome, descricao, preco);
	}

	private static ProdutoDTO toDTO(final ProdutoEntity produtoEntity) {
		final Long id = produtoEntity.getId();
		final String nome = produtoEntity.getNome();
		final String descricao = produtoEntity.getDescricao();
		final String preco = produtoEntity.getPreco();
		return new ProdutoDTO(id, nome, descricao, preco);
	}

	List<ProdutoDTO> getAllProdutos() {
		final List<ProdutoDTO> produtos = new ArrayList<>();
		this.produtoRepository.findAll().forEach(produtoEntity -> produtos.add(ProdutoController.toDTO(produtoEntity)));
		return produtos;
	}

	ProdutoDTO getProduto(final Long id) {
		final Optional<ProdutoEntity> optionalProduto = this.produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			return ProdutoController.toDTO(optionalProduto.get());
		}
		return ProdutoDTO.NULL_VALUE;
	}

	ProdutoDTO removeProduto(final Long id) {
		final Optional<ProdutoEntity> optionalProduto = this.produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			final ProdutoEntity produtoEntity = optionalProduto.get();
			this.produtoRepository.delete(produtoEntity);
			return ProdutoController.toDTO(produtoEntity);
		}
		return ProdutoDTO.NULL_VALUE;
	}

	Long insertProduct(final ProdutoDTO produtoDTO) {
		final ProdutoEntity produtoEntity = ProdutoController.toEntity(produtoDTO);
		this.produtoRepository.save(produtoEntity);
		return produtoEntity.getId();
	}

	ProdutoDTO updateProduto(final Long id, final ProdutoDTO produtoDTO) {
		final Optional<ProdutoEntity> optionalProduto = this.produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			final ProdutoEntity produtoEntity = optionalProduto.get();
			final ProdutoDTO oldProdutoDTO = ProdutoController.toDTO(produtoEntity);
			ProdutoController.updateEntityFromDTO(produtoDTO, produtoEntity);
			this.produtoRepository.save(produtoEntity);
			return oldProdutoDTO;
		}
		return ProdutoDTO.NULL_VALUE;
	}

}
