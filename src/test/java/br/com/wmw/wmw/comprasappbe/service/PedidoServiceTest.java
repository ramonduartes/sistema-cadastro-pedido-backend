package br.com.wmw.wmw.comprasappbe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.wmw.wmw.comprasappbe.dto.ItemPedidoDTO;
import br.com.wmw.wmw.comprasappbe.dto.PedidoDTO;
import br.com.wmw.wmw.comprasappbe.dto.ProdutoDTO;

class PedidoServiceTest {
	
	 private PedidoService pedidoService;
	    private PedidoDTO pedido;

	    @BeforeEach
	    public void inicializa() {
	        this.pedidoService = new PedidoService();
	        this.pedido = criarItem();
	    }

	    @Test
	    void deveriaRetornarTotalDoItem() {
	    	ProdutoDTO produto = new ProdutoDTO(20);
	        pedidoService.calcularDesconto(pedido.getItens().get(0), produto.getPreco());
	        assertEquals(95, pedido.getItens().get(0).getTotalItem());
	    }
	    
	    @Test
		void deveriaCalcularTotalDoPedido() {
			PedidoService pedido = new PedidoService();
			double total = pedido.calcularTotalDoPedido(criarItem());
			assertEquals(95, total);
		}

	    private PedidoDTO criarPedido() {
	        PedidoDTO pedido = new PedidoDTO();
	        pedido.setCodigoCliente(Long.valueOf("1"));
	        pedido.setDataEmissao("2022-09-04");
	        pedido.setDataEntrega("2022-12-04");
	        return pedido;
	    }

	    private PedidoDTO criarItem() {
	        PedidoDTO pedido = criarPedido();
	        pedido.getItens().add(new ItemPedidoDTO(Long.parseLong("1"), Long.parseLong("1"), 5, 20, 5, 95));
	        return pedido;
	    }

	}