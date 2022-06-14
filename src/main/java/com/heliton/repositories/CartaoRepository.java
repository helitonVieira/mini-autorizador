package com.heliton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heliton.domain.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
	
}
