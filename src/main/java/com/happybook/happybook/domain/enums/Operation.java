package com.happybook.happybook.domain.enums;

public enum Operation {

	DECREASE(0, "DECREASE"),
	INCREASE(1, "INCREASE");
	
	private Integer cod;
	private String descricao;
	
	private Operation(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Operation toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Operation x : Operation.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id: Inválido: "+cod);
	}
	
}