package com.heliton.domain.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.heliton.services.validation.TransacaoInsert;

@TransacaoInsert
public class TransacaoDTO {
	
	@NotEmpty
	@NotNull
	private String numeroCartao;	
	@NotEmpty
	@NotNull
	private String senhaCartao;
	
	private BigDecimal valor;

	public TransacaoDTO(String numeroCartao, String senhaCartao, BigDecimal valor) {
		super();
		this.numeroCartao = numeroCartao;
		this.senhaCartao = senhaCartao;
		this.valor = valor;
	}	

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getSenhaCartao() {
		return senhaCartao;
	}

	public void setSenhaCartao(String senhaCartao) {
		this.senhaCartao = senhaCartao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
    
}
