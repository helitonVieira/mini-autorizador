package com.heliton.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.heliton.domain.Cartao;
import com.heliton.domain.dto.CartaoNewDTO;
import com.heliton.repositories.CartaoRepository;

public class CartaoInsertValidator implements ConstraintValidator<CartaoInsert, CartaoNewDTO> {

	@Autowired
	private CartaoRepository repo;
	
	@Override
	public void initialize(CartaoInsert ann) {
	}

	@Override
	public boolean isValid(CartaoNewDTO objDto, ConstraintValidatorContext context) {
		
		List<com.heliton.exceptions.FieldMessage> list = new ArrayList<>();
		
		Cartao aux = repo.findByNumeroCartao(objDto.getNumeroCartao());
		
		if (aux != null){
			list.add(new com.heliton.exceptions.FieldMessage("numeroCartao", "Numero de cartão já existente"));
		}
		
		for (com.heliton.exceptions.FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
			
		return list.isEmpty();
	}
}