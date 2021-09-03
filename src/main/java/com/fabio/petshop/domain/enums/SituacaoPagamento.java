package com.fabio.petshop.domain.enums;

public enum SituacaoPagamento {
	
	QUITADO(1, "Quitado"),
	CANCELADO(2, "Cancelado"),
	PENDENTE(3, "Pendente");
	
	private int cod;
	private String descricao;
	
	
	private SituacaoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao =  descricao;
	}
	

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static SituacaoPagamento toEnum(Integer situacao) {
		if (situacao == null) {
			return null;
		}

		for (SituacaoPagamento x : SituacaoPagamento.values()) {
			if (situacao.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + situacao);
	}
	
		
}
