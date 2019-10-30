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
@Table
public class Categoria implements Serializable {
	
	@Id
	@SequenceGenerator(name="seq_categoria", sequenceName="seq_categoria_id", allocationSize=1)
	@GeneratedValue(generator="seq_categoria" ,strategy= GenerationType.SEQUENCE )
	@Column(name="id", nullable=false , length=3)
	private int id;
	
	@Length(max=40, message="O campo NOME nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo NOME nao pode ficar em branco.!") 
	@NotNull(message="o campo NOME nao pode ser nulo.!")
	@Column(name="nome", nullable=false, length=40)
	private String nome;
	
	
	public Categoria() {
		
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
	
	
}
