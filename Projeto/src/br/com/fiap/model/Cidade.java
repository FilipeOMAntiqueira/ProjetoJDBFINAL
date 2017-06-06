package br.com.fiap.model;

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
public class Cidade {
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
	

	
	
}
