package br.com.fiap.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.model.Cidade;
import br.com.fiap.model.Empresa;
import br.com.fiap.model.Estado;
import br.com.fiap.repository.impl.CidadeRepositoryImpl;
import br.com.fiap.repository.impl.EmpresaRepositoryImpl;
import br.com.fiap.repository.impl.EstadoRepositoryImpl;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projeto");
		EntityManager em = factory.createEntityManager();
		
		EmpresaRepositoryImpl emRepo = new EmpresaRepositoryImpl(em);
		
		CidadeRepositoryImpl ciRepo = new CidadeRepositoryImpl(em);
		
		EstadoRepositoryImpl esRepo = new EstadoRepositoryImpl(em);
		
		int reply = JOptionPane.showConfirmDialog(null, "Deseja criar nova empresa?", "Novo", JOptionPane.YES_NO_OPTION);
		while (reply == JOptionPane.YES_OPTION){
			
			
			Empresa empresa = new Empresa();
			empresa.setNome(perguntar("Qual o nome da empresa?"));
			empresa.setAtuacao(perguntar("Qual a area de atuação?"));
			
			int respostaEstado = JOptionPane.showConfirmDialog(null, "Deseja adicionar um estado de atuação?", "Novo", JOptionPane.YES_NO_OPTION);
			while(respostaEstado == JOptionPane.YES_OPTION){
				Estado estado = new Estado();
				estado.setNome(perguntar("Qual nome do estado?"));
				estado.setUF(perguntarUF("Qual UF do estado?"));
				estado.setEmpresa(empresa);
				empresa.addEstado(estado);
				int respostaCidade = JOptionPane.showConfirmDialog(null, "Deseja adicionar um cidade de atuação?", "Novo", JOptionPane.YES_NO_OPTION);
				while(respostaCidade == JOptionPane.YES_OPTION){
					Cidade cidade = new Cidade();
					cidade.setNome(perguntar("Qual nome da cidade?"));
					respostaCidade = JOptionPane.showConfirmDialog(null, "Deseja adicionar um cidade de atuação?", "Novo", JOptionPane.YES_NO_OPTION);
					cidade.setEstado(estado);
					estado.addCidade(cidade);
					}
				respostaEstado = JOptionPane.showConfirmDialog(null, "Deseja adicionar um estado de atuação?", "Novo", JOptionPane.YES_NO_OPTION);
			}
			emRepo.save(empresa);
			reply = JOptionPane.showConfirmDialog(null, "Deseja criar nova empresa", "Novo", JOptionPane.YES_NO_OPTION);
		}
		
		System.out.println("Listando tudo: ");
		List<Empresa> empresa = emRepo.findAll();
		for(Empresa item : empresa){
			System.out.println(item.toString());
			for(Estado est : item.getEstados()){
				System.out.println(est.toString());
				for(Cidade cid : est.getCidades()){
					System.out.println(cid.toString());
				}
			}
		}
		
		System.out.println("\nPesquisando pela empresa codigo 1: ");
		System.out.println(emRepo.findById(1));
		
		System.out.println("\nPesquisando pelo estado codigo 1 : ");
		System.out.println(esRepo.findById(1));

		System.out.println("\nPesquisando pela cidade codigo 1 : ");
		System.out.println(ciRepo.findById(1));
		
		em.close();
		System.exit(1);
		
		
	}
	
	private static String perguntar(String msg){
		String resposta = JOptionPane.showInputDialog(msg);
		while(resposta== null || resposta.isEmpty()){
			JOptionPane.showMessageDialog(null, "Insira um nome valido! ", "ERROR", 1);
			resposta = JOptionPane.showInputDialog(msg);
		}
		return resposta;
	}

	private static String perguntarUF(String msg){
		String resposta = JOptionPane.showInputDialog(msg);
		while(resposta== null || resposta.isEmpty() || resposta.length()>2){
			JOptionPane.showMessageDialog(null, "Insira um UF válido com no máximo 2 digitos! ", "ERROR", 1);
			resposta = JOptionPane.showInputDialog(msg);
		}
		return resposta;
	}
}
