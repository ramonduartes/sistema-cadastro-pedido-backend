package br.com.wmw.wmw.comprasappbe.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmw.wmw.comprasappbe.dto.PedidoDTO;
import br.com.wmw.wmw.comprasappbe.service.PedidoService;

	@RestController
	@RequestMapping("/pedidos")
	public class PedidoController {
		
		@Autowired
		private PedidoService pedidoService;

		@GetMapping
		public ResponseEntity<List<PedidoDTO>> listaPedidos() {
			return ResponseEntity.ok(pedidoService.lista());
		}

		@GetMapping("/{id}")
		public ResponseEntity<PedidoDTO> detalhar(@PathVariable Long id) throws Exception {
			return ResponseEntity.ok(pedidoService.detalhar(id));
		}
		
		@PostMapping
		public ResponseEntity<PedidoDTO> cadastrar(@RequestBody PedidoDTO pedidoDTO) throws Exception {
			return ResponseEntity.ok(pedidoService.cadastrar(pedidoDTO));
		}
		
		

		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> deletar(@PathVariable Long id) {
			return ResponseEntity.ok(pedidoService.deletar(id));
		}


	}
