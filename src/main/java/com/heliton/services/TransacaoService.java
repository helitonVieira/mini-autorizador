package com.heliton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heliton.domain.Cartao;
import com.heliton.domain.Transacao;
import com.heliton.domain.dto.TransacaoDTO;
import com.heliton.repositories.CartaoRepository;
import com.heliton.repositories.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	TransacaoRepository repo;
	
	@Autowired
	CartaoRepository repoCartao;
	
	@Autowired
	CartaoService serviceCartao;
	
	@Transactional
	public Transacao insert(Transacao obj) {
		
		Cartao objCart = repoCartao.findByNumeroCartao(obj.getNumeroCartao());
		serviceCartao.update(objCart, obj.getValor());
		
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Transacao fromDTO(TransacaoDTO objDto) {
		Transacao trans = new Transacao(null, objDto.getNumeroCartao(), objDto.getSenhaCartao(), objDto.getValor());		
		return trans;
	}
	
}
