package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="venda")
public class Venda implements Serializable {
	
	@Id
	@SequenceGenerator(name="seq_venda",sequenceName="seq_venda_id",allocationSize=1)
	@GeneratedValue(generator="seq_venda",strategy=GenerationType.SEQUENCE)
	@Column(name="id",nullable=false, length=3)
	private int id;
	
	@NotNull(message="O campo DATA nao pode ser nula")
	@Temporal(TemporalType.DATE )
	@Column(name="data ", nullable=false)
	private Calendar data;
	
	@NotNull(message="O campo VALOR TOTAL nao pode ser nulo")
	@Column(name="valor_total", nullable= false , columnDefinition="decimal(12,2)")
	@Min(value=0 , message="O VALOR TOTAL nao pode ser negativo")
	private double valorTotal;
	
	@Min(value=0 , message="As PARCELAs nao pode ter valor negativo")
	@NotNull(message="A quantidade de PARCELAs deve ser informada")
	@Column(name="parcelas", nullable= false )
	private int parcelas;
	
	@NotNull(message="A Pessoa Fisica nao pode ser nula")
	@ManyToOne
	@JoinColumn(name="pessoa_fisica",referencedColumnName="id",nullable=false )
	private PessoaFisica pessoaFisica;
	
	@OneToMany(mappedBy="venda",cascade=CascadeType.ALL, orphanRemoval=false,fetch=FetchType.LAZY)
	private List<VendaItens> itens = new ArrayList<>();
	
	@OneToMany(mappedBy="parcelaID.venda",cascade = CascadeType.ALL, orphanRemoval=false,fetch=FetchType.LAZY)
	private List<Parcela> listaParcelas = new ArrayList<>();

	
	public Venda() {	
	this.valorTotal=0.0;
	}
	
	public void gerarParcelas() {
		double valorParcela = this.valorTotal / this.parcelas;
		for(int i =1; i <=this.parcelas ; i++) {
			Parcela parcela = new Parcela();
			ParcelaID id = new ParcelaID();
			id.setNumero(i);
			id.setVenda(this);
			parcela.setParcelaID(id);
			parcela.setValor(valorParcela);
			Calendar vencimento = (Calendar) this.data.clone();
			vencimento.add(Calendar.MONTH, i);
			parcela.setVencimento(vencimento);
			this.listaParcelas.add(parcela);
		}
	}
	
	
	public void adicionarItens(VendaItens obj) {
		obj.setVenda(this);
		this.valorTotal += obj.getValorTotal();
		this.itens.add(obj);
		
	}
	
	public void removerItem(int index) {
		VendaItens obj = this.itens.get(index);
		this.valorTotal -= obj.getValorTotal();
		this.itens.remove(index);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	public List<VendaItens> getItens() {
		return itens;
	}
	public void setItens(List<VendaItens> itens) {
		this.itens = itens;
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
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
