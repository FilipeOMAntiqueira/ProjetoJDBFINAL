package br.com.fiap.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="ESTADO")
public class Estado implements Serializable{
	/**
	 * Classe responsável pela tabela ESTADO
	 * @author filipemoraes
	 * 
	 */
	private static final long serialVersionUID = 5323758222603603808L;

	@Id
	@Column(name="CODIGO", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="UF", length=2)
	private String UF;
	
	@Column(name="NOME")
	private String nome;
	
	@Override
	public String toString() {
		return "Estado [codigo=" + codigo + ", UF=" + UF + ", nome=" + nome + ", empresa=" + empresa.getCodigo() + "]";
	}

	public Estado(int codigo, String uF, String nome, Empresa empresa, List<Cidade> cidades) {
		super();
		this.codigo = codigo;
		UF = uF;
		this.nome = nome;
		this.setEmpresa(empresa);
		this.cidades = cidades;
	}

	public Estado() {
		super();
	}

	public Empresa getEmpresa() {
		return empresa;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Empresa.class)
	@JoinColumn(name="EMPRESA")
	private Empresa empresa;
	
	@OneToMany(mappedBy="estado", cascade=CascadeType.ALL)
	private List<Cidade> cidades = new ArrayList<>();
	
	public void addCidade(Cidade cidade){
		cidades.add(cidade);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
