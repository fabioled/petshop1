package com.fabio.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabio.petshop.domain.Categoria;
import com.fabio.petshop.domain.Cidade;
import com.fabio.petshop.domain.Endereco;
import com.fabio.petshop.domain.Especie;
import com.fabio.petshop.domain.Estado;
import com.fabio.petshop.domain.Pagamento;
import com.fabio.petshop.domain.PagamentoCartao;
import com.fabio.petshop.domain.PagamentoDinheiro;
import com.fabio.petshop.domain.PessoaCliente;
import com.fabio.petshop.domain.PessoaFuncionario;
import com.fabio.petshop.domain.Pet;
import com.fabio.petshop.domain.Produto;
import com.fabio.petshop.domain.Raca;
import com.fabio.petshop.domain.Servico;
import com.fabio.petshop.domain.enums.SituacaoPagamento;
import com.fabio.petshop.repository.CategoriaRepository;
import com.fabio.petshop.repository.CidadeRepository;
import com.fabio.petshop.repository.EnderecoRepository;
import com.fabio.petshop.repository.EspecieRepository;
import com.fabio.petshop.repository.EstadoRepository;
import com.fabio.petshop.repository.PagamentoRepository;
import com.fabio.petshop.repository.PessoaRepository;
import com.fabio.petshop.repository.PetRepository;
import com.fabio.petshop.repository.ProdutoRepository;
import com.fabio.petshop.repository.RacaRepository;
import com.fabio.petshop.repository.ServicoRepository;

@Component
public class PopulaDados {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired 
	ProdutoRepository produtoRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	EspecieRepository especieResitory;
	
	@Autowired
	RacaRepository racaRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository; 
	
	@Autowired
	private ServicoRepository servicoRepository; 
	
	@Autowired
	private PagamentoRepository pagamentoRepository; 
	
	@PostConstruct
	public void cadastrar() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Alimento");
		Categoria cat2 = new Categoria(null, "Remédio");	
		Categoria cat3 = new Categoria(null, "Cosmético");
		
		Produto p1 = new Produto(null, "Ração", 100.0);
		Produto p2 = new Produto(null, "Sache", 10.0);
		Produto p3 = new Produto(null, "Vermifugo", 20.0);		
		Produto p4 = new Produto(null, "Shampoo", 50.0); 
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));		
		cat3.getProdutos().addAll(Arrays.asList(p4));		

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2, cat3));
		 				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		Especie esp1 = new Especie(null, "Cachorro");
		Especie esp2 = new Especie(null, "Gato");
		
		Raca rac1 = new Raca(null, "Shitzu");
		Raca rac2 = new Raca(null, "Akita");
		Raca rac3 = new Raca(null, "Persa");
		
		Pet pet1 = new Pet(null, "John", 6, esp1,rac1);  
		Pet pet2 = new Pet(null, "Hana", 5, esp1,rac2); 
		Pet pet3 = new Pet(null, "Mewth", 8, esp2,rac3); 
		
		especieResitory.saveAll(Arrays.asList(esp1, esp2));
		racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
		
		petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));	
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "Capelinha", est1);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
				
		est1.getCidades().addAll(Arrays.asList(c1,c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		PessoaCliente clt1 = new PessoaCliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");
		clt1.getTelefones().addAll(Arrays.asList("3516-2000","9191-0000"));
		
		PessoaFuncionario fnc1 = new PessoaFuncionario(null, "Maria Jose", "maria@mail.com", "551.872.200-12", "ATENDENTE");
		fnc1.getTelefones().addAll(Arrays.asList("3279-0001","9090-0002"));
		
		Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30110111", clt1, c1);
		Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "30100333", fnc1, c2);
		Endereco end3 = new Endereco(null, "Rua Aranas", "10", "Apto 201", "Centro", "38100333", fnc1, c3);
		
		clt1.getEnderecos().addAll(Arrays.asList(end1));
		fnc1.getEnderecos().addAll(Arrays.asList(end2,end3));
		
		pessoaRepository.saveAll(Arrays.asList(clt1, fnc1));		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Servico srv1 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", clt1, fnc1, pet1);
		Servico srv2 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hotel", clt1, fnc1, pet2);
		Servico srv3 = new Servico(null, sdf.parse("05/09/2021 16:00"), sdf.parse("05/09/2021 16:30"), "Vermifugação", clt1, fnc1, pet3);
		
		Pagamento pgt1 = new PagamentoCartao(null, SituacaoPagamento.QUITADO, 60.00, srv1, 4);
		srv1.setPagamento(pgt1);
		
		Pagamento pgt2 = new PagamentoDinheiro(null, SituacaoPagamento.PENDENTE, 100.00, srv2, 10.0, sdf.parse("04/09/2021 12:00"));
		srv2.setPagamento(pgt2);
		
		Pagamento pgt3 = new PagamentoDinheiro(null, SituacaoPagamento.QUITADO, 75.00, srv3, 0.0, sdf.parse("05/09/2021 16:00"));
		srv3.setPagamento(pgt3);
		
		clt1.getServicos().addAll(Arrays.asList(srv1, srv2, srv3));
				
		servicoRepository.saveAll(Arrays.asList(srv1, srv2, srv3));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2, pgt3));		
		
	}

}
