package br.com.ufms.si.serv;

import br.com.ufms.si.model.Cliente;
import br.com.ufms.si.serv.ClienteService.ClienteSearch;

public interface ClienteService extends AbstractService<Cliente, ClienteSearch> {

	public interface ClienteSearch {

		Integer getCodigo();

	}

}
