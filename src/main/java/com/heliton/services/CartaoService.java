package com.heliton.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.heliton.domain.Cartao;
import com.heliton.repositories.CartaoRepository;

@Service
public class CartaoService {
	
	private CartaoRepository repo;
	
	public Cartao find(String numeroCartao) {
		Optional<Cartao> obj = repo.findById(numeroCartao);
		return obj.orElse(null);
	}
	
	public Cartao insert(Cartao obj) {
		obj.setSaldo(new BigDecimal(500));
		return repo.save(obj);
	}
}
