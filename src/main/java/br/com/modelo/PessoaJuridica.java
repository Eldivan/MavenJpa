package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;


@Table(name="pessoa_juridica")
@Entity
public class PessoaJuridica extends Pessoa implements Serializable  {
	

	@Length(max=25, message="O tamnho maximo do campo IE e {max}")
	@NotNull(message="O ampo IE não pode ser nulo")
	@NotEmpty(message="O campo IE nao pode ficar em branco.!")
	@Column(name="ie", nullable= false , length=25)
	private String ie;
	
	@CNPJ(message="O CNPJ deve ser valido")
	@Length(max=20, message="O tamnho maximo do campo CNPJ e {max}")
	@NotNull(message="O ampo CNPJ não pode ser nulo")
	@NotEmpty(message="O campo CNPJ nao pode ficar em branco.!")
	@Column(name="cnpj", nullable= false , length=20)
	private String cnpj;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="fornece",
		joinColumns=
		@JoinColumn(name="pessoa_juridica",referencedColumnName="id",nullable=false),
		inverseJoinColumns=
		@JoinColumn(name="produto",referencedColumnName="id",nullable=false),
		uniqueConstraints = {@UniqueConstraint(columnNames= {"pessoa_juridica", "produto"})})	
	private List<Produto> listaDefornecedores = new ArrayList<>();

	public PessoaJuridica() {		
	}
	
	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Produto> getListaDefornecedores() {
		return listaDefornecedores;
	}

	public void setListaDefornecedores(List<Produto> listaDefornecedores) {
		this.listaDefornecedores = listaDefornecedores;
	}

	

	
	
	
}
