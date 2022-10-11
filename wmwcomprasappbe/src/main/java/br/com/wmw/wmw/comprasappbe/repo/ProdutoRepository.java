package br.com.wmw.wmw.comprasappbe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wmw.wmw.comprasappbe.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
