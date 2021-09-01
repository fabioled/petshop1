package com.fabio.petshop.domain;

import java.util.Date;

import com.fabio.petshop.domain.enums.SituacaoPagamento;

public class Cartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	private Integer parcelas;
	
	public Cartao() {
		
	}

	public Cartao(Integer id, SituacaoPagamento situacao, Double valor, Servico servico, Integer parcelas) {
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
