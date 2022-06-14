package com.heliton.resources;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heliton.domain.Cartao;

@RestController
@RequestMapping(value = "/cartoes") 
public class CartaoResource {
	
	@RequestMapping(method=RequestMethod.GET) 
	public List<Cartao> listar() { 
		Cartao cat1 = new Cartao(new BigInteger("6549873025634501"),"123",new BigDecimal(500));
		Cartao cat2 = new Cartao(new BigInteger("6549873025634502"),"123",new BigDecimal(500));
			 
		 List<Cartao> lista = new ArrayList<>(); 
		 lista.add(cat1); 
		 lista.add(cat2); 
		 
		 return lista; 
	}

}
