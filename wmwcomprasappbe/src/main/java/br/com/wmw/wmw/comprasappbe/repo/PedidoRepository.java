package br.com.wmw.wmw.comprasappbe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wmw.wmw.comprasappbe.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
