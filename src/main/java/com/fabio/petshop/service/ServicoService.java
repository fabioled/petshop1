package com.fabio.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.petshop.domain.Servico;
import com.fabio.petshop.repository.ServicoRepository;
import com.fabio.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repo;

	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encotrado! ID: " + id + ", Tipo: " + Servico.class.getName()));

	}
	
	public List<Servico> findAll(){
		return repo.findAll();
	}

}
