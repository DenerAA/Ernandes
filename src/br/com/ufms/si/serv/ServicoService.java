package br.com.ufms.si.serv;

import br.com.ufms.si.model.Servico;
import br.com.ufms.si.serv.ServicoService.ServicoSearch;

public interface ServicoService extends AbstractService<Servico, ServicoSearch> {

	public interface ServicoSearch {

		String getTipo();

		String getDescricao();
	}

}
