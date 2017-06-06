package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa {

	@Id
	@Column(name = "CODIGO", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "ATUACAO")
	private String atuacao;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Estado> estados = new ArrayList<>();

	public void addEstado(Estado estado) {
		estados.add(estado);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtuacao() {
		return atuacao;
	}

	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Empresa(int codigo, String nome, String atuacao, List<Estado> estados) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.atuacao = atuacao;
		this.estados = estados;
	}

	public Empresa() {
		super();
	}

	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", nome=" + nome + ", atuacao=" + atuacao + "]";
	}




	
}
