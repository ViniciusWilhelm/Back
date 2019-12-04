package br.web.senai.funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
final class FuncionarioController {

	private final FuncionarioRepository funcionarioRepository; 
	
	FuncionarioController(final FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository =funcionarioRepository;
		
		}

	private static void updateEntityFromDTO(final FuncionarioDTO funcionarioDTO, final FuncionarioEntity funcionarioEntity) {
		funcionarioEntity.setId(funcionarioDTO.getId());
		funcionarioEntity.setNome(funcionarioDTO.getNome());
		funcionarioEntity.setSetor(funcionarioDTO.getSetor());
		funcionarioEntity.setCargo(funcionarioDTO.getCargo());
		funcionarioEntity.setSalario(funcionarioDTO.getSalario());
	}

	private static FuncionarioEntity toEntity(final FuncionarioDTO funcionarioDTO) {
		final Long id = funcionarioDTO.getId();
		final String nome = funcionarioDTO.getNome();
		final String setor = funcionarioDTO.getSetor();
		final String cargo = funcionarioDTO.getCargo();
		final Long salario = funcionarioDTO.getSalario();
		return new FuncionarioEntity(id, nome, setor, cargo,salario);
	}

	private static FuncionarioDTO toDTO(final FuncionarioEntity funcionarioEntity) {
		final Long id = funcionarioEntity.getId();
		final String nome = funcionarioEntity.getNome();
		final String setor = funcionarioEntity.getSetor();
		final String cargo = funcionarioEntity.getCargo();
		final Long salario = funcionarioEntity.getSalario();
		return new FuncionarioDTO(id, nome, setor, cargo, salario);
	}

	List<FuncionarioDTO> getAllFuncionarios() {
		final List<FuncionarioDTO> funcionarios = new ArrayList<>();
		this.funcionarioRepository.findAll().forEach(funcionarioEntity -> funcionarios.add(FuncionarioController.toDTO(funcionarioEntity)));
		return funcionarios;
	}

	FuncionarioDTO getFuncionario(final Long id) {
		final Optional<FuncionarioEntity> optionalFuncionario = this.funcionarioRepository.findById(id);
		if (optionalFuncionario.isPresent()) {
			return FuncionarioController.toDTO(optionalFuncionario.get());
		}
		return FuncionarioDTO.NULL_VALUE;
	}

	FuncionarioDTO removeFuncionario(final Long id) {
		final Optional<FuncionarioEntity> optionalFuncionario= this.funcionarioRepository.findById(id);
		if (optionalFuncionario.isPresent()) {
			final FuncionarioEntity funcionarioEntity = optionalFuncionario.get();
			this.funcionarioRepository.delete(funcionarioEntity);
			return FuncionarioController.toDTO(funcionarioEntity);
		}
		return FuncionarioDTO.NULL_VALUE;
	}

	Long insertFuncionario(final FuncionarioDTO funcionarioDTO) {
		final FuncionarioEntity funcionarioEntity = FuncionarioController.toEntity(funcionarioDTO);
		this.funcionarioRepository.save(funcionarioEntity);
		return funcionarioEntity.getId();
	}

	FuncionarioDTO updateFuncionario(final Long id, final FuncionarioDTO funcionarioDTO) {
		final Optional<FuncionarioEntity> optionalFuncionario = this.funcionarioRepository.findById(id);
		if (optionalFuncionario.isPresent()) {
			final FuncionarioEntity funcionarioEntity = optionalFuncionario.get();
			final FuncionarioDTO oldFuncionarioDTO = FuncionarioController.toDTO(funcionarioEntity);
			FuncionarioController.updateEntityFromDTO(funcionarioDTO, funcionarioEntity);
			this.funcionarioRepository.save(funcionarioEntity);
			return oldFuncionarioDTO;
		}
		return FuncionarioDTO.NULL_VALUE;
	}

}

 
 