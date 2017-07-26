package br.com.ufms.si.serv;

import br.com.ufms.si.model.Cliente;
import br.com.ufms.si.model.Endereco;
import br.com.ufms.si.model.Evento;
import br.com.ufms.si.serv.EventoService.EventoSearch;

public interface EventoService extends AbstractService<Evento, EventoSearch> {

	public interface EventoSearch {

		Endereco getLocal();

		Cliente getCliente();
	}

}
