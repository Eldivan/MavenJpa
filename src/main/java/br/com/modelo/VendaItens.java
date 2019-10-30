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
@Table(name="venda_itens")
public class VendaItens implements Serializable {
	
	@Id
	@SequenceGenerator(name="seq_venda_itens",sequenceName="seq_venda_itens_id",allocationSize=1)
	@GeneratedValue(generator="seq_venda_itens",strategy=GenerationType.SEQUENCE)
	@Column(name="id",nullable=false, length=3)
	private int id;
	
	@NotNull(message="O campo QUANTIDADE nao pode ser nulo")
	@Min(value=0 , message="A QUANTIDADE nao pode ser negativo")
	@Column(name="quantidade", nullable= false, columnDefinition="decimal(12,2)")
	private double quantidade;
	
	@NotNull(message="O campo VALOR UNITARIO nao pode ser nulo")
	@Column(name="valor_unitario", nullable= false , columnDefinition="decimal(12,2)")
	@Min(value=0 , message="O VALOR UNITARIO nao pode ser negativo")
	private double valorUnitario;
	
	@NotNull(message="O campo VALOR TOTAL nao pode ser nulo")
	@Column(name="valor_total", nullable = false , columnDefinition="decimal(12,2)")
	@Min(value=0 , message="O VALOR TOTAL nao pode ser negativo")
	private double valorTotal;
	
	@ForeignKey(name="fk_venda")
	@NotNull(message="O campo VENDA ITENS nao pode ser nula")
	@ManyToOne
	@JoinColumn(name="venda",referencedColumnName="id",nullable=false )
	private Venda venda;
	
	@ForeignKey(name="fk_produto")
	@NotNull(message="O campo PRODUTO nao pode ser nulo")
	@ManyToOne
	@JoinColumn(name="produto",referencedColumnName="id",nullable=false )
	private Produto produto;
	

	public VendaItens() {
							
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
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
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
		VendaItens other = (VendaItens) obj;
		if (id != other.id)
			return false;
		return true;
	}
		
	
}
