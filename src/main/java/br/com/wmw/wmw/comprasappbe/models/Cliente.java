package br.com.wmw.wmw.comprasappbe.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	private String cnpj_cpf;
	private String email;
	private String telefone;
	
	

	
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
	public void setId(Long id) {
		this.id = id;
	}
	public String getcnpj_cpf() {
		return cnpj_cpf;
	}
	public void setcnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cnpj_cpf, email, id, nome, telefone, tipoPessoa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cnpj_cpf, other.cnpj_cpf) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone) && tipoPessoa == other.tipoPessoa;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", tipoPessoa=" + tipoPessoa + ", cnpj_cpf=" + cnpj_cpf
				+ ", email=" + email + ", telefone=" + telefone + "]";
	}
	
	
	

}
