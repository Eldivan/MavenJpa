package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="compra")
public class Compra implements Serializable {
	
	@EmbeddedId
	private CompraID id;
	
	@NotNull(message="O campo DATA nao pode ser nulo")
	@Temporal(TemporalType.DATE )
	@Column(name="data", nullable=false)
	private Calendar data;
	
	@NotNull(message="O campo VALOR TOTAL nao pode ser nulo")
	@Column(name="valor_total", nullable= false , columnDefinition="decimal(12,2)")
	@Min(value=0 , message="O VALOR TOTAL nao pode ser negativo")
	private double valorTotal;
	
	@OneToMany(mappedBy="compra",cascade = CascadeType.ALL, orphanRemoval=false,fetch=FetchType.LAZY)
	private List<CompraItem> listaItens = new ArrayList<>();
	
	
	
	public Compra() {
		valorTotal=0.0;
	}
	
	public void adicionarItem(CompraItem obj) {
		obj.setCompra(this);
		valorTotal += obj.getValorTotal();
		this.listaItens.add(obj);
		
	}
	public void removerItem(int index) {
		CompraItem obj = (CompraItem) this.listaItens.get(index);
		valorTotal -= obj.getValorTotal();
		this.listaItens.remove(index);
		
	}

	public CompraID getId() {
		return id;
	}

	public void setId(CompraID id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	public List<CompraItem> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<CompraItem> listaItens) {
		this.listaItens = listaItens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Compra other = (Compra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
