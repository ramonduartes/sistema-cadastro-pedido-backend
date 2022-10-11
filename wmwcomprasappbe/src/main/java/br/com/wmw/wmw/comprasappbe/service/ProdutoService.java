package br.com.wmw.wmw.comprasappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.wmw.wmw.comprasappbe.dto.ProdutoDTO;
import br.com.wmw.wmw.comprasappbe.models.Produto;
import br.com.wmw.wmw.comprasappbe.repo.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> lista() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDTO.converter(produtos);
	}
	
	public ProdutoDTO detalhar(@PathVariable Long id) throws Exception {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return new ProdutoDTO(produto.get());
		} else {
			throw new Exception();
		}
	}

}
