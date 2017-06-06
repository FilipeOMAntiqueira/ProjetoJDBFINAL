package br.com.fiap.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CIDADE")
public class Cidade implements Serializable{
	/**
	 * Classe responsável pela tabela CIDADE
	 * @author filipemoraes
	 */
	private static final long serialVersionUID = -8053132526435821974L;

	@Id
	@Column(name="CODIGO", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOME")
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Estado.class)
	@JoinColumn(name="ESTADO")
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado.getCodigo() + "]";
	}

	public Cidade(int id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public Cidade() {
		super();
	}
	
	
	
	
}
