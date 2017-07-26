package br.com.ufms.si.model;

public class ServicoContratado {

	private Long id;

	private Integer quantidade;

	private Servico servico;

	private Evento evento;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

}
