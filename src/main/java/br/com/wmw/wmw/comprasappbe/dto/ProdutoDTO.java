package br.com.wmw.wmw.comprasappbe.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.wmw.wmw.comprasappbe.models.Produto;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private double preco;
	
	public ProdutoDTO(double preco) {
		this.preco = preco;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public ProdutoDTO (Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		
	}
	
	public static List<ProdutoDTO> converter(List<Produto> produto) {
		return produto.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	
	}
}
