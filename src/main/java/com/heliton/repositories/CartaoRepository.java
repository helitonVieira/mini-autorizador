package com.heliton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.heliton.domain.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
	
	@Transactional(readOnly = true)
	Cartao findByNumeroCartao(String numeroCartao);	
}
