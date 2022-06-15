package com.heliton.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.heliton.domain.Cartao;
import com.heliton.domain.dto.TransacaoDTO;
import com.heliton.repositories.CartaoRepository;

public class TransacaoInsertValidator implements ConstraintValidator<TransacaoInsert, TransacaoDTO> {

	@Autowired
	private CartaoRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder  pe;
	
	@Override
	public void initialize(TransacaoInsert ann) {
	}

	@Override
	public boolean isValid(TransacaoDTO objDto, ConstraintValidatorContext context) {
		
		List<com.heliton.exceptions.FieldMessage> list = new ArrayList<>();
		
		Cartao aux = repo.findByNumeroCartao(objDto.getNumeroCartao());
		
		if(objDto.getValor().doubleValue() > aux.getSaldo().doubleValue() ) {
			list.add(new com.heliton.exceptions.FieldMessage("valor", "SALDO_INSUFICIENTE"));
		}
		
		if(!pe.matches(objDto.getSenhaCartao(),  aux.getSenha()) ) {
			list.add(new com.heliton.exceptions.FieldMessage("senhaCartao", "SENHA_INVALIDA"));
		}
		
		if (aux.equals(null) ){
			list.add(new com.heliton.exceptions.FieldMessage("numeroCartao", "CARTAO_INEXISTENTE"));
		}
		
		for (com.heliton.exceptions.FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
			
		return list.isEmpty();
	}
}