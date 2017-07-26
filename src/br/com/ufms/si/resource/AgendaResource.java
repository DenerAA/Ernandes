package br.com.ufms.si.resource;

import java.sql.Date;
import java.util.List;

import br.com.ufms.si.model.Agenda;
import br.com.ufms.si.model.Evento;
import br.com.ufms.si.serv.AgendaService;
import br.com.ufms.si.serv.AgendaService.AgendaSearch;

public class AgendaResource {

	private Evento evento;

	private Date dataInicial;

	private Date dataFinal;

	private AgendaService service;

	public AgendaResource() {

	}

	public AgendaResource(Evento evento, Date dataInicial, Date dataFinal) {
		this.evento = evento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Agenda load(Integer id) {
		return service.load(id);
	}

	public void create(Agenda entity) {
		service.create(entity);
	}

	public Agenda update(Agenda entity) {
		return service.update(entity);
	};

	public List<Agenda> search() {
		Search search = new Search();
		return service.search(search);
	}

	List<Agenda> loadAll() {
		return service.loadAll();
	}

	public void delete(Long id) {
		service.delete(id);
	};

	public class Search implements AgendaSearch {

		@Override
		public Evento getEvento() {
			return evento;
		}

		@Override
		public Date getDateInicial() {
			return dataInicial;
		}

		@Override
		public Date getDataFinal() {
			return dataFinal;
		}

	}

}
