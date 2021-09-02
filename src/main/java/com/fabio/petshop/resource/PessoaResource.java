package com.fabio.petshop.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.petshop.domain.Pessoa;
import com.fabio.petshop.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Pessoa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
			
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> findAll() {
		
		List<Pessoa> list = service.findAll();		
		return ResponseEntity.ok().body(list);
		
	}
	
}
