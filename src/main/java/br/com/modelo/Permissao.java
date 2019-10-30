package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="permissao")
public class Permissao implements Serializable {
	
	@Id
	@NotEmpty(message="O NOME  nao pode ficar em branco")
	@NotNull(message="O NOME nao pode ser nulo")
	@Length(max=40,message= "O tamanho maximo do campo NOME e {max} caracteres")
	@Column(name="nome", nullable= false , length=40)
	private String nome;
	
	@NotEmpty(message="A DESCRICAO nao pode ficar em branco")
	@NotNull(message="A DESCRICAO nao pode ser nula")
	@Length(max=40,message= "O tamanho maximo do campo DESCRICAO e {max} caracteres")
	@Column(name="descricao", nullable= false , length=40 )
	private String descricao;
	
	
	public Permissao() {
		
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Permissao other = (Permissao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	


	
	
	
	
}
