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
	private double totalItem;
	
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.idProduto = itemPedido.getProduto().getId();
		this.quantidade = itemPedido.getQuantidade();
		this.precoUnitario = itemPedido.getPrecoUnitario();
		this.desconto = itemPedido.getDesconto();
		this.totalItem = itemPedido.getTotalItem();
	}
	
	public ItemPedidoDTO(long id, long produto, double quantidade, double precoUnitario, double desconto, double total) {
		this.id = id;
		this.idProduto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.desconto = desconto;
		this.totalItem = total;
		
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
	public double getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(double totalItem) {
		this.totalItem = totalItem;
	}
	
	

}
