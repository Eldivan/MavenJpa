package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Table(name="pessoa_fisica")
@Entity
public class PessoaFisica extends Pessoa implements Serializable {
	

	@Length(max=15, message="O tamnho maximo do campo nome e {max}")
	@NotNull(message="O ampo RG não pode ser nulo")
	@NotEmpty(message="O campo RG nao pode ficar em branco.!")
	@Column(name="rg", nullable= false , length=15)
	private String rg ;
	

	@Length(max=12, message="O tamnho maximo do campo nome e {max}")
	@NotNull(message="O ampo CPF não pode ser nulo")
	@NotEmpty(message="O campo CPF nao pode ficar em branco.!")
	@CPF(message="O CPF deve ser valido")
	@Column(name="cpf", nullable= false , length=12)
	private String cpf;
	
	@NotNull(message="O campo NASCIMENTO nao pode ser nulo")
	@Temporal(TemporalType.DATE )
	@Column(name="nascimento", nullable=false)
	private Calendar nascimento;
	

	@Length(max=30, message="O tamnho maximo do campo NOME USUARIO e {max}")
	@NotNull(message="O ampo NOME USUARIO  não pode ser nulo")
	@NotEmpty(message="O campo NOME USUARIO nao pode ficar em branco.!")
	@Column(name="nome_usuario", nullable= false , length=30)
	private String nomeUsuario;
	

	@Length(max=30, message="O tamnho maximo do campo SENHA e {max}")
	@NotNull(message="O ampo SENHA não pode ser nulo")
	@NotEmpty(message="O campo SENHA nao pode ficar em branco.!")
	@Column(name="senha", nullable= false , length=30)
	private String senha;
	

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="lista_de_produtos",
		joinColumns=
		@JoinColumn(name="pessoa_fisica",referencedColumnName="id",nullable=false),
		inverseJoinColumns=
		@JoinColumn(name="produto",referencedColumnName="id",nullable=false),
		uniqueConstraints = {@UniqueConstraint(columnNames= {"pessoa_fisica", "produto"})})	
	private List<Produto> listaDeProdutos = new ArrayList<>();

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="permissoes",
		joinColumns=
		@JoinColumn(name="nome_usuario",referencedColumnName="nome_usuario",nullable=false),
		inverseJoinColumns=
		@JoinColumn(name="permissao",referencedColumnName="nome ",nullable=false),
		uniqueConstraints = {@UniqueConstraint(columnNames= {"nome_usuario", "permissao"})})	
	private List<Permissao> listaPermissoes = new ArrayList<>();
	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public List<Permissao> getListaPermissoes() {
		return listaPermissoes;
	}

	public void setListaPermissoes(List<Permissao> listaPermissoes) {
		this.listaPermissoes = listaPermissoes;
	}
	
	

}
