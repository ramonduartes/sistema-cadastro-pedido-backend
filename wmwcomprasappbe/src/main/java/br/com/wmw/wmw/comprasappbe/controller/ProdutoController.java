package br.com.wmw.wmw.comprasappbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmw.wmw.comprasappbe.dto.ProdutoDTO;
import br.com.wmw.wmw.comprasappbe.service.ProdutoService;

@RequestMapping("/produtos")
@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> lista() {
		return ResponseEntity.ok(produtoService.lista());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> detalhar(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(produtoService.detalhar(id));
	}
	
	

}
