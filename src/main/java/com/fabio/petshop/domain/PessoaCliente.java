package com.fabio.petshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PessoaCliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String tipo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Servico> servicos = new ArrayList<>();
	
	
	public PessoaCliente() {
		
	}

	public PessoaCliente(Integer id, String nome, String email, String codNacional, String tipo) {
		super(id, nome, email, codNacional);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
