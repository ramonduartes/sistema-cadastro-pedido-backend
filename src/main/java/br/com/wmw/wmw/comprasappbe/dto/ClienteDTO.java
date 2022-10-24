package br.com.wmw.wmw.comprasappbe.dto;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.wmw.wmw.comprasappbe.models.Cliente;
import br.com.wmw.wmw.comprasappbe.models.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Insira o nome do Cliente")
	private String nome;

	@NotBlank(message = "Insira se é pessoa FISICA ou JURIDICA")
	private TipoPessoa tipoPessoa;

	@CPF
	@CNPJ
	@NotBlank(message = "Insira o CPF ou CNPJ")
	private String cnpj_cpf;

	@NotBlank(message = "Insira o telefone")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String telefone;

	@NotBlank(message = "Insira o email")
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

