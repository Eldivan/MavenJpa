package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class ParcelaID implements Serializable {
	
	@NotNull(message="O numero nao podeser nullo!!")
	@Column(name="numero",nullable=false)
	private int numero;
	
	@NotNull(message="A VENDA nao pode ser nula!!")
	@ManyToOne
	@JoinColumn(name="venda", referencedColumnName="id", nullable=false)
	private Venda venda;
	
	
	public ParcelaID() {
	
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
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
		ParcelaID other = (ParcelaID) obj;
		if (numero != other.numero)
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}
	
	
}
