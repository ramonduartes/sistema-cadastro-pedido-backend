package br.com.wmw.wmw.comprasappbe.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.wmw.wmw.comprasappbe.models.Pedido;
import br.com.wmw.wmw.comprasappbe.models.StatusPedido;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PedidoDTO {
	
	private Long codigoPedido;
	private Long codigoCliente;
	private String dataEmissao;
	private String dataEntrega;
	@Positive
	private Double totalPedido;
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	private List<ItemPedidoDTO> itens = new ArrayList<>();
	
	public PedidoDTO() {
		
	}
	
	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
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

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long cod_pedido) {
		this.codigoPedido = cod_pedido;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long cod_cliente) {
		this.codigoCliente = cod_cliente;
	}

	

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public List<ItemPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}

	public static List<PedidoDTO> converter(List<Pedido> pedido) {
		return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
	
	public PedidoDTO(Pedido pedido) {
		this.codigoPedido = pedido.getId();
		this.codigoCliente = pedido.getCliente().getId();
		this.dataEmissao = pedido.getDataEmissao();
		this.dataEntrega = pedido.getDataEntrega();
		this.totalPedido = pedido.getTotalPedido();
		this.statusPedido = pedido.getStatus();
		this.itens.addAll(pedido.getItens().stream().map(ItemPedidoDTO::new).collect(Collectors.toList()));
	}
	
}
