package com.heliton.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Cartao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	private String numeroCartao;
	private String senha;
	private BigDecimal saldo;
	
	public Cartao() {
		
	}
	
	public Cartao(String numeroCartao, String senha, BigDecimal saldo) {
		super();
		this.numeroCartao = numeroCartao;
		this.senha = senha;
		this.saldo = saldo;
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
