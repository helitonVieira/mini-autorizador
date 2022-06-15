package com.heliton.domain.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.heliton.services.validation.CartaoInsert;

@CartaoInsert
public class CartaoNewDTO {

	@Id	
	@NotEmpty
	@NotNull
	@Column(unique = true)
	private String numeroCartao;
	@NotEmpty
	@NotNull
	private String senha;
	private BigDecimal saldo;
	
	
	public CartaoNewDTO() {
		
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
