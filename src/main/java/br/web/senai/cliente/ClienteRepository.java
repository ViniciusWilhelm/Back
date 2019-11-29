package br.web.senai.cliente;

import org.springframework.data.repository.CrudRepository;

import br.web.senai.pedido.PedidoEntity;

interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

}
