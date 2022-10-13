package br.com.wmw.wmw.comprasappbe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wmw.wmw.comprasappbe.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
