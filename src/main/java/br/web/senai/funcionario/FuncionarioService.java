package br.web.senai.funcionario;

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

import br.web.senai.funcionario.FuncionarioDTO;

@RestController
@RequestMapping("/api/funcionario")
public final class FuncionarioService {

	private final FuncionarioController funcionarioController;

	FuncionarioService(final FuncionarioController funcionarioController) {
	    this.funcionarioController = funcionarioController;
	}

	@GetMapping("/lista")
	public List<FuncionarioDTO> list() {
		return this.funcionarioController.getAllFuncionarios();
	}

	@GetMapping("/{id}/detalhes")
	public ResponseEntity<FuncionarioDTO> getFuncionario(@PathVariable final Long id) {
		final FuncionarioDTO funcionario = this.funcionarioController.getFuncionario(id);
		if (funcionario.equals(FuncionarioDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> removeFuncionario(@PathVariable final Long id) {
		final FuncionarioDTO removedFuncionario = this.funcionarioController.removeFuncionario(id);
		if (removedFuncionario.equals(FuncionarioDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedFuncionario, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable final Long id, @RequestBody final FuncionarioDTO funcionario) {
		final FuncionarioDTO oldFuncionario = this.funcionarioController.updateFuncionario(id, funcionario);
		if (oldFuncionario.equals(FuncionarioDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldFuncionario, HttpStatus.OK);
	}
					
	@PostMapping
	public Long insertFuncionario(@RequestBody final FuncionarioDTO funcionario) {
		return this.funcionarioController.insertFuncionario(funcionario);
	}

}
