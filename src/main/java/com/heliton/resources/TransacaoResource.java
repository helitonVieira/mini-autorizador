package com.heliton.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heliton.domain.Transacao;
import com.heliton.domain.dto.TransacaoDTO;
import com.heliton.services.TransacaoService;


@RestController
@RequestMapping(value = "/transacoes") 
public class TransacaoResource {
	
	@Autowired
	private TransacaoService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insert(@Valid @RequestBody TransacaoDTO objDto) {
		Transacao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body("OK");
	}

}
