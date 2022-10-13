package br.com.wmw.wmw.comprasappbe.dto;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.wmw.wmw.comprasappbe.models.Cliente;
import br.com.wmw.wmw.comprasappbe.models.TipoPessoa;


public class ClienteDTO implements Serializable {

	private Long id;

	private String nome;

	private TipoPessoa tipoPessoa;

	
	private String cnpj_cpf;

	
	private String telefone;

	
	private String email;

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.tipoPessoa = cliente.getTipoPessoa();
		this.cnpj_cpf = cliente.getcnpj_cpf();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
	}

	public static List<ClienteDTO> converter(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
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

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCnpj_cpf() {
		return cnpj_cpf;
	}

	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

