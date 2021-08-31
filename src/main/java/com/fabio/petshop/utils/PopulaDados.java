package com.fabio.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabio.petshop.domain.Categoria;
import com.fabio.petshop.domain.Produto;
import com.fabio.petshop.repository.CategoriaRepository;
import com.fabio.petshop.repository.ProdutoRepository;

@Component
public class PopulaDados {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired 
	ProdutoRepository ProdutoRepository;
	
	@PostConstruct
	public void cadastrar() {
		
		Categoria cat1 = new Categoria(null, "Alimento");
		Categoria cat2 = new Categoria(null, "Remédio");	
		Categoria cat3 = new Categoria(null, "Cosmético");
		
		Produto p1 = new Produto(null, "Ração", 100.0);
		Produto p2 = new Produto(null, "Vermifugo", 10.0);
		Produto p3 = new Produto(null, "Sache", 10.0);
		Produto p4 = new Produto(null, "Shampoo", 50.0); 
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));		
		cat3.getProdutos().addAll(Arrays.asList(p4));		

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2, cat3));
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		ProdutoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}

}
