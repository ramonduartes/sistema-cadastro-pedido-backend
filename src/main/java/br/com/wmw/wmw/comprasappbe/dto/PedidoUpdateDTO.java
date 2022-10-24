package br.com.wmw.wmw.comprasappbe.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.wmw.wmw.comprasappbe.models.Pedido;
import br.com.wmw.wmw.comprasappbe.models.StatusPedido;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoUpdateDTO {

	private Long id;
	private String dataEntrega;
	@Positive
	private Double totalPedido;
	private StatusPedido status;
	private List<ItemPedidoDTO> itens = new ArrayList<>();

	public static List<PedidoUpdateDTO> converter(List<Pedido> pedido) {
		return pedido.stream().map(PedidoUpdateDTO::new).collect(Collectors.toList());
	}

	public PedidoUpdateDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.dataEntrega = pedido.getDataEntrega();
		this.totalPedido = pedido.getTotalPedido();
		this.status = pedido.getStatus();
		this.itens.addAll(pedido.getItens().stream().map(ItemPedidoDTO::new).collect(Collectors.toList()));
	}
	
	public PedidoUpdateDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ItemPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}

	
	
}
