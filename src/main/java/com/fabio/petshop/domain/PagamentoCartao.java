package com.fabio.petshop.domain;

import javax.persistence.Entity;

import com.fabio.petshop.domain.enums.SituacaoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	private Integer parcelas;
	
	public PagamentoCartao() {
		
	}

	public PagamentoCartao(Integer id, SituacaoPagamento situacao, Double valor, Servico servico, Integer parcelas) {
		super(id, situacao, valor, servico);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
		
}
