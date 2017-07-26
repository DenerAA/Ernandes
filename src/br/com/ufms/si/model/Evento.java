package br.com.ufms.si.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Evento {

	private Long id;

	private Integer quantidadeConvidados;

	private Endereco local;

	private Cliente cliente;

	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public Integer getQuantidadeConvidados() {
		return quantidadeConvidados;
	}

	public void setQuantidadeConvidados(Integer quantidadeConvidados) {
		this.quantidadeConvidados = quantidadeConvidados;
	}

	public Endereco getLocal() {
		return local;
	}

	public void setLocal(Endereco local) {
		this.local = local;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
