package com.heliton.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Cartao implements Serializable {
	private static final long serialVersionUID = 1L;
	
		
	private BigInteger numeroCartao;
	private String senha;
	private BigDecimal saldo;
	
	public Cartao() {
		
	}
	
	public Cartao(BigInteger numeroCartao, String senha, BigDecimal saldo) {
		super();
		this.numeroCartao = numeroCartao;
		this.senha = senha;
		this.saldo = saldo;
	}

	public BigInteger getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(BigInteger numeroCartao) {
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
