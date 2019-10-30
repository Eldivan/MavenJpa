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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;


@Table(name="cidade")
@Entity
public class Cidade implements Serializable{
	
	@Id
	@SequenceGenerator (name="seq_cidade", sequenceName="seq_cidade_id", allocationSize =1)
	@GeneratedValue(generator="seq_cidade", strategy= GenerationType.SEQUENCE)
	@Column(name="id", nullable= false ,length=4 )
	private int id;
	
	@Length(max=20, message="O campo NOME nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo NOME nao pode ficar em branco.!") 
	@NotNull(message="o campo NOME nao pode ser nulo.!")
	@Column(name="nome", nullable=false, length=20)
	private String nome;
	
	@ForeignKey(name="fk_estado")
	@NotNull(message="O campo ESTADO nao pode ser nulo")
	@ManyToOne
	@JoinColumn(name="estado",referencedColumnName="id",nullable=false )
	private Estado estado;
		
		public Cidade() {
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
	
		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
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
			Cidade other = (Cidade) obj;
			if (id != other.id)
				return false;
			return true;
		}
}
