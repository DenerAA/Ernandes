package br.com.ufms.si.serv;

import java.sql.Date;

import br.com.ufms.si.model.Agenda;
import br.com.ufms.si.model.Evento;
import br.com.ufms.si.serv.AgendaService.AgendaSearch;

public interface AgendaService extends AbstractService<Agenda, AgendaSearch> {

	public interface AgendaSearch {

		Evento getEvento();

		Date getDateInicial();

		Date getDataFinal();

	}

}
