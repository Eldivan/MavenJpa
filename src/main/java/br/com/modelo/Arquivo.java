package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="arquivo")
public class Arquivo implements Serializable{
	
	
	@Id
	@SequenceGenerator (name="seq_arquivo", sequenceName="seq_arquivo_id", allocationSize =1)
	@GeneratedValue(generator="seq_arquivo", strategy= GenerationType.SEQUENCE)
	@Column(name="id", nullable= false ,length=4 )
	private int id;
	
	@Length(max=20, message="O campo NOME nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo NOME nao pode ficar em branco.!") 
	@NotNull(message="o campo NOME nao pode ser nulo.!")
	@Column(name="nome", nullable=false, length=20)
	private String nome;
	
	@Length(max=20, message="O campo DESCRICAO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo DESCRICAO nao pode ficar em branco.!") 
	@NotNull(message="o campo DESCRICAO nao pode ser nulo.!")
	@Column(name="descricao", nullable=false, length=20)
	private String descricao;
	
	@Lob
	@NotNull(message="o campo ARQUIVO nao pode ser nulo.!")
	@Column(name="arquivo", nullable=false, length=20)
	private byte[] arquivo;
	
	@ForeignKey(name="fk_produto")
	@NotNull(message="O campo PRODUTO nao pode ser nulo!!")
	@ManyToOne
	@JoinColumn(name="produto", referencedColumnName="id", nullable=false)
	private Produto produto;
	
	
	public Arquivo() {
		
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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
		Arquivo other = (Arquivo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
