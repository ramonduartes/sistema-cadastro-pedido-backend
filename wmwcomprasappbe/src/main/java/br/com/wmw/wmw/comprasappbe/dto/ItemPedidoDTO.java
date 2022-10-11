package br.com.wmw.wmw.comprasappbe.dto;

import javax.validation.constraints.NotBlank;

import br.com.wmw.wmw.comprasappbe.models.ItemPedido;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
	
	private Long cod_itempedido;
	@NotBlank
	private Long cod_produto;
	@NotBlank
	@Positive
	private Double quantidade;
	private Double precoUnitario;
	private Double desconto;
	private Double totalItem;
	
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.cod_itempedido = itemPedido.getId();
		this.cod_produto = itemPedido.getProduto().getId();
		this.quantidade = itemPedido.getQuantidade();
		this.precoUnitario = itemPedido.getPrecoUnitario();
		this.desconto = itemPedido.getDesconto();
		this.totalItem = itemPedido.getTotalItem();
	}
	
	public ItemPedidoDTO() {
		
	}
	
	public Long getCod_itempedido() {
		return cod_itempedido;
	}

	public void setCod_itempedido(Long cod_itempedido) {
		this.cod_itempedido = cod_itempedido;
	}

	public Long getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Long cod_produto) {
		this.cod_produto = cod_produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Double totalItem) {
		this.totalItem = totalItem;
	}
	
	

}
