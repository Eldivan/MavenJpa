package br.com.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="parcela")
public class Parcela implements Serializable {

	@EmbeddedId
	private ParcelaID parcelaID;
	
	@NotNull(message="O campo VALOR nao pode ser nulo")
	@Column(name="valor", nullable= false , columnDefinition="decimal(12,2)")
	@Min(value=0 , message="O VALOR nao pode ser negativo")
	private double valor;
	
	@NotNull(message="O campo VENCIMENTO nao pode ser nulo")
	@Temporal(TemporalType.DATE )
	@Column(name="vencimento", nullable=false)
	private Calendar vencimento;
	
	@NotNull(message="O campo VALOR PAGAMENTO nao pode ser nulo")
	@Column(name="valor_pagamento", nullable= false , columnDefinition="decimal(12,2)")
	@Min(value=0 , message="O VALOR PAGAMENTO nao pode ser negativo")
	private double valorPagamento;
	
	
	@Temporal(TemporalType.DATE )
	@Column(name="data_Pagamento")
	private Calendar dataPagamento;
	

	
	public Parcela() { 
		
	}
	public ParcelaID getParcelaID() {
		return parcelaID;
	}
	public void setParcelaID(ParcelaID parcelaID) {
		this.parcelaID = parcelaID;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Calendar getVencimento() {
		return vencimento;
	}
	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}
	public double getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public Calendar getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parcelaID == null) ? 0 : parcelaID.hashCode());
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
		Parcela other = (Parcela) obj;
		if (parcelaID == null) {
			if (other.parcelaID != null)
				return false;
		} else if (!parcelaID.equals(other.parcelaID))
			return false;
		return true;
	}
	
}
