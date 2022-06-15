package com.heliton.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heliton.domain.Cartao;
import com.heliton.domain.dto.CartaoNewDTO;
import com.heliton.repositories.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repo;
	
	public Cartao find(String numeroCartao) {
		Optional<Cartao> obj = repo.findById(numeroCartao);
		return obj.orElseThrow(() -> new com.heliton.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! Cartão: " + numeroCartao));
	}
	
	public Cartao insert(Cartao obj) {
	
		obj.setSaldo(new BigDecimal(500));
		return repo.save(obj);
	}
	
	public Cartao fromDTO(CartaoNewDTO objDto) {
		Cartao cart = new Cartao(objDto.getNumeroCartao(),objDto.getSenha(),objDto.getSaldo());		
		return cart;
	}
	
	public Cartao findByNumeroCartao(String numeroCartao) {		
	
		Cartao obj = repo.findByNumeroCartao(numeroCartao);
		if (obj == null) {
			throw new com.heliton.services.exceptions.ObjectNotFoundException(
					"Objeto não encontrado! Cartão de numero: " +numeroCartao );
		}
		return obj;
	}
	
}
