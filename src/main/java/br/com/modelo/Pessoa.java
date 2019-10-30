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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Inheritance(strategy=InheritanceType.JOINED)
@Table (name="pessoa")
@Entity
public class Pessoa implements Serializable {
	
	@Id
	@SequenceGenerator(name="seq_pessoa",sequenceName="seq_pessoa_id",allocationSize=1)
	@GeneratedValue(generator="seq_pessoa",strategy=GenerationType.SEQUENCE)
	@Column(name="id",nullable=false, length=3)
	private int id;
	
	@Length(max=30, message="O tamnho maximo do campo nome e {max}")
	@NotNull(message="O ampo NOME não pode ser nulo")
	@NotEmpty(message="O campo NOME nao pode ficar em branco.!")
	@Column(name="nome", nullable= false , length=30)
	private String nome;
	
	@Length(max=10, message="O tamnho maximo do campo nome e {max}")
	@NotNull(message="O ampo TELEFONE não pode ser nulo")
	@NotEmpty(message="O campo TELEFONE nao pode ficar em branco.!")
	@Column(name="telefone", nullable= false , length=10)
	private String telefone;
	
	@Length(max=50, message="O tamnho maximo do campo nome e {max}")
	@NotNull(message="O ampo EMAIL não pode ser nulo")
	@NotEmpty(message="O campo EMAIL nao pode ficar em branco.!")
	@Column(name="email", nullable= false , length=50)
	private String email;
	
	@OneToMany(mappedBy="pessoa", cascade=CascadeType.ALL , orphanRemoval=true , fetch=FetchType.LAZY )
	List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa() {
		
	}

	public void adicionarEndereco(Endereco obj) {
		obj.setPessoa(this);
		this.enderecos.add(obj);
	}
	
	public void removerEndereco(int index) {
		 this.enderecos.remove(index);	
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
