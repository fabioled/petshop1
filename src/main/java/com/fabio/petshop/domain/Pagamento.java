package com.fabio.petshop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fabio.petshop.domain.enums.SituacaoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer situacao;
	private Double valor;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_servico")
	@MapsId
	private Servico servico;
	
	public Pagamento() {
		
	}

	public Pagamento(Integer id, SituacaoPagamento situacao, Double valor, Servico servico) {
		super();
		this.id = id;
		this.situacao = situacao.getCod();
		this.valor = valor;
		this.servico = servico;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SituacaoPagamento getSituacao() {
		return SituacaoPagamento.toEnum(situacao);
	}

	public void setSituacao(SituacaoPagamento situacao) {
		this.situacao = situacao.getCod();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
	
}