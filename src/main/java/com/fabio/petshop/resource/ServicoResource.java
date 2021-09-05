package com.fabio.petshop.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.petshop.domain.Servico;
import com.fabio.petshop.service.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {
	
	@Autowired
	private ServicoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servico> find(@PathVariable Integer id){
		Servico obj = service.find(id);
		return ResponseEntity.ok().body(obj);
			
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Servico>> findAll() {
		
		List<Servico> list = service.findAll();		
		return ResponseEntity.ok().body(list);
		
	}
	
}
