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

@Table(name="tipo_endereco")
@Entity
public class TipoEndereco implements Serializable{
	
	@Id
	@SequenceGenerator (name="seq_tipo_endereco", sequenceName="seq_tipo_endereco_id", allocationSize =1)
	@GeneratedValue(generator="seq_tipo_endereco", strategy= GenerationType.SEQUENCE)
	@Column(name="id", nullable= false ,length=4 )
	private int id;
	
	@Length(max=20, message="O campo DESCRICAO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo DESCRICAO nao pode ficar em branco.!") 
	@NotNull(message="o campo DESCRICAO nao pode ser nulo.!")
	@Column(name="decricao", nullable=false, length=20)
	private String decricao;
	
	
	public TipoEndereco() {
			}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDecricao() {
		return decricao;
	}
	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
	
	

}
