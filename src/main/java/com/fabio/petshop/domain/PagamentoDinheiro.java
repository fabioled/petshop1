package com.fabio.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fabio.petshop.domain.enums.SituacaoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoDinheiro extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	private Double desconto;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoDinheiro() {
		
	}

	public PagamentoDinheiro(Integer id, SituacaoPagamento situacao, Double valor, Servico servico, Double desconto, Date dataPagamento) {
		super(id, situacao, valor, servico);
		this.desconto = desconto;
		this.dataPagamento = dataPagamento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
}
