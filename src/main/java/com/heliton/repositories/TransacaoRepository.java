package com.heliton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heliton.domain.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
