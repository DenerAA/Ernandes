package br.com.ufms.si.model;

import java.sql.Date;

public class Agenda {

	private Long id;

	private Date data;

	private Evento evento;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
