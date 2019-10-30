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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
	
	@Entity
	@Table(name="estado")
	public class Estado implements Serializable {

		@Id
		@SequenceGenerator(name="seq_estado",sequenceName="seq_estado_id", allocationSize=1)
		@GeneratedValue(generator="seq_estado",strategy= GenerationType.SEQUENCE)
		@Column(name="id", nullable=false, length=3)
		private int id;
		
		@Length(max = 40, message="O tamanho {max} do campo NOME e {max} caracteres")
		@NotEmpty(message="O campo NOME nao pode ser em branco")
		@NotNull(message="O campo NOME nao aceita valores nulo")
		@Column(name="nome", nullable= false, length=40)
		private String nome;
		
		@Length(max = 3, message="O tamanho maximo do campo UF e {max} caracteres ")
		@NotEmpty(message="O campo UF nao pode ser em branco")
		@NotNull(message="O campo UF nao aceita valores nulo")
		@Column(name="uf", nullable= false, length=3)
		private String uf;
		
		@ForeignKey(name="fk_pais")
		@NotNull(message="O campo PAIS nao pode ser nulo")
		@ManyToOne
		@JoinColumn(name="pais",referencedColumnName="id",nullable=false )
		private Pais pais;
		
		
		
		public Estado() {
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

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		} 

		public Pais getPais() {
			return pais;
		}

		public void setPais(Pais pais) {
			this.pais = pais;
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
			Estado other = (Estado) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
	}

	
	

