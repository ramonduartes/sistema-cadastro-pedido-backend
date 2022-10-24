package br.com.wmw.wmw.comprasappbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.wmw.wmw.comprasappbe.dto.ItemPedidoDTO;
import br.com.wmw.wmw.comprasappbe.dto.PedidoDTO;
import br.com.wmw.wmw.comprasappbe.dto.PedidoUpdateDTO;
import br.com.wmw.wmw.comprasappbe.models.Cliente;
import br.com.wmw.wmw.comprasappbe.models.ItemPedido;
import br.com.wmw.wmw.comprasappbe.models.Pedido;
import br.com.wmw.wmw.comprasappbe.models.Produto;
import br.com.wmw.wmw.comprasappbe.repo.ClienteRepository;
import br.com.wmw.wmw.comprasappbe.repo.ItemPedidoRepository;
import br.com.wmw.wmw.comprasappbe.repo.PedidoRepository;
import br.com.wmw.wmw.comprasappbe.repo.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemPedidoRepository itemRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public List<PedidoDTO> lista() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return PedidoDTO.converter(pedidos);
	}

	public PedidoDTO detalhar(@PathVariable Long id) throws Exception {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return new PedidoDTO(pedido.get());
		} else {
			throw new Exception();
		}
	}



	public PedidoDTO cadastrar(PedidoDTO pedidoDTO) throws Exception {


		Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoDTO.getCodigoPedido());
		if (pedidoOptional.isPresent()) {
			pedidoRepository.delete(pedidoOptional.get());
		}

		Pedido pedido = new Pedido();

		pedido.setId(pedidoDTO.getCodigoPedido());
		pedido.setTotalPedido(pedidoDTO.getTotalPedido());
		pedido.setDataEmissao(pedidoDTO.getDataEmissao());
		pedido.setDataEntrega(pedidoDTO.getDataEntrega());
		pedido.setStatus(pedidoDTO.getStatusPedido());

		Optional<Cliente> cliente = clienteRepository.findById(pedidoDTO.getCodigoCliente());
		if (cliente.isPresent()) {
			pedido.setCliente(cliente.get());
		} else {
			throw new Exception();
		}

		pedidoDTO.getItens().stream().forEach(item -> {
			try {
				double precoProduto = produtoRepository.getReferenceById(item.getIdProduto()).getPreco();
				if (calcularDesconto(item, precoProduto).compareTo(item.getTotalItem()) != 0){
					throw new Exception("O valor do item está diferente");
				} else {
					novoItemPedido(item, pedido);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});

        pedidoRepository.save(pedido);
        pedidoDTO = new PedidoDTO(pedido);
         return pedidoDTO;
    }

	private void novoItemPedido(ItemPedidoDTO itemPedidoDTO, Pedido pedido) throws Exception {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setId(itemPedidoDTO.getId());
		itemPedido.setTotalItem(itemPedidoDTO.getTotalItem());
		itemPedido.setDesconto(itemPedidoDTO.getDesconto());
		itemPedido.setPrecoUnitario(itemPedidoDTO.getPrecoUnitario());
		itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());

		itemPedido.setPedido(pedido);

		Optional<Produto> produto = produtoRepository.findById(itemPedidoDTO.getIdProduto());
		if (produto.isPresent()) {
			itemPedido.setProduto(produto.get());
		} else {
			throw new Exception();
		}

		pedido.getItens().add(itemPedido);
	}

	public Double calcularTotalDoPedido(PedidoDTO pedidoDTO){
		return pedidoDTO.getItens().stream().mapToDouble(itemPedidoDTO -> itemPedidoDTO.getTotalItem()).sum();
	}

	public PedidoUpdateDTO atualizar(PedidoUpdateDTO pedidoUpdateDTO) throws Exception {

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoUpdateDTO.getId());
        if (!pedidoOptional.isPresent()) {
            throw new Exception();
        }

        Pedido pedido = pedidoOptional.get();

        pedido.setId(pedidoUpdateDTO.getId());
        pedido.setTotalPedido(pedidoUpdateDTO.getTotalPedido());
        pedido.setDataEntrega(pedidoUpdateDTO.getDataEntrega());
        pedido.setStatus(pedidoUpdateDTO.getStatus());


        pedidoUpdateDTO.getItens().stream().forEach(item -> {
            Optional<ItemPedido> itemOptional = itemRepository.findById(item.getId());
            if (!itemOptional.isPresent()) {
                try {
                    novoItemPedido(item, pedido);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        pedidoRepository.save(pedido);
        pedidoUpdateDTO = new PedidoUpdateDTO(pedido);
        return pedidoUpdateDTO;
    }

	public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }


	public Double calcularDesconto(ItemPedidoDTO itemPedidoDTO, double precoProduto){
		double valorItemComDesconto = ((100 - itemPedidoDTO.getDesconto()) * 0.01) * precoProduto;
		return valorItemComDesconto * itemPedidoDTO.getQuantidade();
	}
	
	
	
}

