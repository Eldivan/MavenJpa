package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class CompraID implements Serializable {
	
	@NotNull(message="O NUMERO DA NOTA  nao podeser nullo!!")
	@Column(name="numero_da_nota",nullable=false)
	private int numeroNota;
	
	@NotNull(message="A PESSOA JURIDICA nao pode ser nula!!")
	@ManyToOne
	@JoinColumn(name="pessoa_juridica", referencedColumnName="id", nullable=false)
	private PessoaJuridica pessoaJuridica;
	
	

	public CompraID() {
		
	}

	public int getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(int numeroNota) {
		this.numeroNota = numeroNota;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroNota;
		result = prime * result + ((pessoaJuridica == null) ? 0 : pessoaJuridica.hashCode());
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
		CompraID other = (CompraID) obj;
		if (numeroNota != other.numeroNota)
			return false;
		if (pessoaJuridica == null) {
			if (other.pessoaJuridica != null)
				return false;
		} else if (!pessoaJuridica.equals(other.pessoaJuridica))
			return false;
		return true;
	}
	
	
	
	

}
