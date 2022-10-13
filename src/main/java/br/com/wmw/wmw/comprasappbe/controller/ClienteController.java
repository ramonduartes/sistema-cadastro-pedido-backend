package br.com.wmw.wmw.comprasappbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmw.wmw.comprasappbe.dto.ClienteDTO;
import br.com.wmw.wmw.comprasappbe.service.ClienteService;



@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> lista() {
		return ResponseEntity.ok(clienteService.lista());
	}


	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> detalhar(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(clienteService.detalhar(id));
	}
	
	
	

}
