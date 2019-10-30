package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="compra_item")
public class CompraItem implements Serializable {
	
	@Id
	@SequenceGenerator(name="seq_compra_item",sequenceName="seq_compra_item_id",allocationSize=1)
	@GeneratedValue(generator="seq_compra_item",strategy=GenerationType.SEQUENCE)
	@Column(name="id",nullable=false, length=3)
	private int id;
	
	@NotNull(message="O campo QUANTIDADE nao pode ser nulo")
	@Min(value=0 , message="A QUANTIDADE nao pode ser negativo")
	@Column(name="quantidade", nullable= false, columnDefinition="decimal(10,2)")
	private double quantidade;
	
	@NotNull(message="O campo VALOR UNITARIO nao pode ser nulo")
	@Column(name="valor_unitario", nullable= false , columnDefinition="decimal(10,2)")
	@Min(value=0 , message="O VALOR UNITARIO nao pode ser negativo")
	private double valorUnitario;
	
	@NotNull(message="O campo VALOR TOTAL nao pode ser nulo")
	@Column(name="valor_total", nullable = false , columnDefinition="decimal(10,2)")
	@Min(value=0 , message="O VALOR TOTAL nao pode ser negativo")
	private double valorTotal;
	
	@ForeignKey(name="fk_produto")
	@NotNull(message="O campo PRODUTO ITEM nao pode ser nulo!!!")
	@ManyToOne
	@JoinColumn(name="produto",referencedColumnName="id",nullable=false )
	private Produto produto;
	
	@ForeignKey(name="fk_compra")
	@NotNull(message="O campo COMPRA nao pode ser nula")
	@ManyToOne
	private Compra compra;
	
	
	public CompraItem() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
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
		CompraItem other = (CompraItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
