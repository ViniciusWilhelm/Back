package br.web.senai.funcionario;

import org.springframework.data.repository.CrudRepository;

interface FuncionarioRepository extends CrudRepository<FuncionarioEntity, Long> {

}
