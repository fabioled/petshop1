package com.fabio.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.petshop.domain.Pessoa;
import com.fabio.petshop.repository.PessoaRepository;
import com.fabio.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encotrado! ID: " + id + ", Tipo: " + Pessoa.class.getName()));

	}
	
	public List<Pessoa> findAll(){
		return repo.findAll();
	}

}
