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

@Table(name="endereco")
@Entity
public class Endereco implements Serializable {
	
	@Id
	@SequenceGenerator (name="seq_endereco", sequenceName="seq_endereco_id", allocationSize =1)
	@GeneratedValue(generator="seq_endereco", strategy= GenerationType.SEQUENCE)
	@Column(name="id", nullable= false ,length=4 )
	private int id;
	
	@Length(max=20, message="O campo NICK NAME nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo NICK NAME nao pode ficar em branco.!") 
	@NotNull(message="o campo NICK NAME nao pode ser nulo.!")
	@Column(name="apelido", nullable=false, length=20)
	private String nickname;
	
	@Length(max=50, message="O campo ENDERECO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo ENDERECO nao pode ficar em branco.!") 
	@NotNull(message="o campo ENEDERECO nao pode ser nulo.!")
	@Column(name="endereco", nullable=false, length=50)
	private String endereco;
	
	@Length(max=5, message="O campo NUMERO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo NUMERO nao pode ficar em branco.!") 
	@NotNull(message="o campo NUMERO nao pode ser nulo.!")
	@Column(name="numero", nullable=false, length=5)
	private String numero;
	
	@Length(max=40, message="O campo COMPLEMENTO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo COMPLEMENTO nao pode ficar em branco.!") 
	@NotNull(message="o campo COMPLEMENTO nao pode ser nulo.!")
	@Column(name="complemento", nullable=false, length=40)
	private String complemento; 
	
	@Length(max=9, message="O campo CEP nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo CEP nao pode ficar em branco.!") 
	@NotNull(message="o campo CEP nao pode ser nulo.!")
	@Column(name="cep", nullable=false, length=9)
	private String cep;
	
	@Length(max=40, message="O campo BAIRRO nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo BAIRRO nao pode ficar em branco.!") 
	@NotNull(message="o campo BAIRRO nao pode ser nulo.!")
	@Column(name="bairro", nullable=false, length=40)
	private String bairro;
	
	@Length(max=40, message="O campo REFERENCIA nao pode ter mais de {max} caracteres!")
	@NotEmpty(message="O campo REFERENCIA nao pode ficar em branco.!") 
	@NotNull(message="o campo REFERENCIA nao pode ser nulo.!")
	@Column(name="referencia", nullable=false, length=40)
	private String referencia;
	
	@org.hibernate.annotations.ForeignKey (name="fk_cidade")
	@NotNull(message="O campo CIDADE nao pode ser nulo")
	@ManyToOne
	@JoinColumn(name="cidade",referencedColumnName="id",nullable=false )
	private Cidade cidade;
	
	@org.hibernate.annotations.ForeignKey (name="fk_tipo_endereco")
	@NotNull(message="O campo TIPO ENDERECO nao pode ser nulo")
	@ManyToOne
	@JoinColumn(name="tipo_endereco",referencedColumnName="id",nullable=false )
	private TipoEndereco tipoEndereco;
	
	@NotNull(message="A pessoa deve ser informada")
	@ManyToOne
	@JoinColumn(name="pessoa_id", referencedColumnName="id",nullable= false)
	@NotEmpty(message="O campo PESSOA nao pode ficar em branco")
	@ForeignKey(name="fk_pessoa_id")
	private Pessoa pessoa;
	
	public Endereco() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Endereco other = (Endereco) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}
