package com.fabio.petshop.domain.enums;

public enum SituacaoPagamento {
	
	QUITADO(1, "Quitado"),
	CANCELADO(2, "Pendente"),
	PENDENTE(3, "Cancelado");
	
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

	public static SituacaoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (SituacaoPagamento x : SituacaoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
		
}
