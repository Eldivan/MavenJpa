package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="produto")
public class Produto implements Serializable{
	
	@Id
	@SequenceGenerator (name="seq_produto", sequenceName="seq_produto_id", allocationSize =1)
	@GeneratedValue(generator="seq_produto", strategy= GenerationType.SEQUENCE)
	@Column(name="id", nullable= false ,length=4 )
	private int id;
	
	@Length(max=40, message="O campo NOME nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo NOME nao pode ficar em branco.!") 
	@NotNull(message="o campo NOME nao pode ser nulo.!")
	@Column(name="nome", nullable=false, length=40)
	private String nome;
	
	@Length(max=6, message="O campo PRECO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo PRECO nao pode ficar em branco.!") 
	@NotNull(message="o campo PRECO nao pode ser nulo.!")
	@Column(name="preco", nullable=false, length=6)
	private double preco;
	
	@Length(max=40, message="O campo QUAUNTIDADE EM ESTOQUE nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo QUANTIDADE EM ESTOQUE pode ficar em branco.!") 
	@NotNull(message="o campo QUANTIDADE EM ESTOQUE nao pode ser nulo.!")
	@Column(name="quantidade_estoque", nullable=false, length=40)
	private double quantidadeEstoque;
	
	@Length(max=40, message="O campo DESCRICAO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo DESCRICAO nao pode ficar em branco.!") 
	@NotNull(message="o campo DESCRICAO nao pode ser nulo.!")
	@Column(name="descricao", nullable=false, length=40)
	private String descricao;

	@ManyToMany
	@JoinTable(name="lista_de_produtos",
			joinColumns=
			@JoinColumn(name="produto",referencedColumnName="id",nullable=false),
			inverseJoinColumns=
			@JoinColumn(name="pessoa_fisica",referencedColumnName="id",nullable=false),
			uniqueConstraints = {@UniqueConstraint(columnNames= {"pessoa_fisica", "produto"})})	
	private List<PessoaFisica> listaDesejados = new ArrayList<>();
	
	@ForeignKey(name="fk_marca")
	@NotNull(message="O campo MARCA nao pode ser nulo")
	@ManyToOne
	@JoinColumn(name="marca",referencedColumnName="id",nullable=false )
	private Marca marca;
	
	@ForeignKey(name="fk_categoria")
	@NotNull(message="O campo CATEGORIA nao pode ser nulo")
	@ManyToOne
	@JoinColumn(name="categoria",referencedColumnName="id",nullable=false )
	private Categoria categoria;
	
	
	@OneToMany(mappedBy="produto",cascade= CascadeType.ALL , orphanRemoval=true , fetch=FetchType.LAZY)
	private List<Foto> fotos = new ArrayList<>();
	
	
	@OneToMany(mappedBy="produto",cascade= CascadeType.ALL , orphanRemoval=true , fetch=FetchType.LAZY)
	private List<Arquivo> arquivos = new ArrayList<>();
	
	
	
	@ManyToMany
	@JoinTable(name="fornece",
			joinColumns=
			@JoinColumn(name="produto",referencedColumnName="id",nullable=false),
			inverseJoinColumns=
			@JoinColumn(name="pessoa_juridica",referencedColumnName="id",nullable=false),
			uniqueConstraints = {@UniqueConstraint(columnNames= {"pessoa_juridica", "produto"})})	
	private List<PessoaFisica> listaDesejos = new ArrayList<>();
	
	public Produto() {
	}
	
	public void adicionarFoto(Foto obj) {
		obj.setProduto(this);
		this.fotos.add(obj);
	}
	
	public void removerFoto(int index) {
		this.fotos.remove(index);
	}
	
	public void adicionarArquivo(Arquivo obj) {
		obj.setProduto(this);
		this.arquivos.add(obj);
	}
	
	public void removerArquivo(int index) {
		this.arquivos.remove(index);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(double quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PessoaFisica> getListaDesejados() {
		return listaDesejados;
	}

	public void setListaDesejados(List<PessoaFisica> listaDesejados) {
		this.listaDesejados = listaDesejados;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public List<PessoaFisica> getListaDesejos() {
		return listaDesejos;
	}

	public void setListaDesejos(List<PessoaFisica> listaDesejos) {
		this.listaDesejos = listaDesejos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;	
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
