package com.fabio.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.petshop.domain.Categoria;
import com.fabio.petshop.repository.CategoriaRepository;
import com.fabio.petshop.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encotrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));

	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Categoria update(Categoria obj) {		
		find(obj.getId());
		return repo.save(obj);
	}

}
