package com.fabio.petshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataEntrada;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataSaida;
	private String descricao;
		
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "servico")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private PessoaCliente cliente;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private PessoaFuncionario funcionario;
	
	@ManyToMany
	@JoinTable(name = "SERVICO_PRODUTO", 
		joinColumns = @JoinColumn(name = "id_servico"),
		inverseJoinColumns = @JoinColumn(name = "id_produto"))
	private List<Produto> produtos = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pet")
	private Pet pet;

	public Servico() {
		
	}	

	public Servico(Integer id, Date dataEntrada, Date dataSaida, String descricao, PessoaCliente cliente,
			PessoaFuncionario funcionario, Pet pet) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.descricao = descricao;		
		this.setCliente(cliente);
		this.setFuncionario(funcionario);
		this.pet = pet;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public PessoaCliente getCliente() {
		return cliente;
	}

	public void setCliente(PessoaCliente cliente) {
		this.cliente = cliente;
	}

	public PessoaFuncionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(PessoaFuncionario funcionario) {
		this.funcionario = funcionario;
	}
		
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
