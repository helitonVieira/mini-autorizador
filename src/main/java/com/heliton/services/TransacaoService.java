package com.heliton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heliton.domain.Transacao;
import com.heliton.repositories.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	TransacaoRepository repo;
	
	public Transacao insert(Transacao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
