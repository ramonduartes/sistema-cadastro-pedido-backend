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
	
	private Long id;
	@NotBlank
	private Long idProduto;
	@NotBlank
	@Positive
	private Double quantidade;
	private Double precoUnitario;
	private Double desconto;
	private Double totalItem;
	
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.idProduto = itemPedido.getProduto().getId();
		this.quantidade = itemPedido.getQuantidade();
		this.precoUnitario = itemPedido.getPrecoUnitario();
		this.desconto = itemPedido.getDesconto();
		this.totalItem = itemPedido.getTotalItem();
	}
	
	public ItemPedidoDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long cod_itempedido) {
		this.id = cod_itempedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long cod_produto) {
		this.idProduto = cod_produto;
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