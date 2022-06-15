package com.heliton.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.heliton.domain.Cartao;
import com.heliton.services.validation.CartaoInsert;

@CartaoInsert
public class CartaoNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

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
	
	public CartaoNewDTO(Cartao obj) {
		numeroCartao = obj.getNumeroCartao();
		senha = obj.getSenha();
		saldo = obj.getSaldo();
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
