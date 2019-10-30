package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table (name="marca")
public class Marca implements Serializable {
	
	@Id
	@SequenceGenerator (name="seq_marca", sequenceName="seq_marca_id", allocationSize =1)
	@GeneratedValue(generator="seq_marca", strategy= GenerationType.SEQUENCE)
	@Column(name="id", nullable= false ,length=4 )
	private int id;
	
	@Length(max=20, message="O campo NOME nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo NOME nao pode ficar em branco.!") 
	@NotNull(message="o campo NOME nao pode ser nulo.!")
	@Column(name="nome", nullable=false, length=20)
	private String nome;

	public Marca() {
		
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
		Marca other = (Marca) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
