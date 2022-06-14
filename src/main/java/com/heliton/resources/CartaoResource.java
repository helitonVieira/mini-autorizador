package com.heliton.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.heliton.domain.Cartao;
import com.heliton.services.CartaoService;

@RestController
@RequestMapping(value = "/cartoes") 
public class CartaoResource {
	
	@Autowired
	private CartaoService service;
	
	@RequestMapping(value="/{numeroCartao}",method=RequestMethod.GET) 
	public ResponseEntity<Cartao> find(@PathVariable String numeroCartao) { 
		Cartao obj = service.find(numeroCartao);	 
		return ResponseEntity.ok().body(obj);
	}
		
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Cartao> insert(@Valid @RequestBody Cartao obj) {			
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}

}
