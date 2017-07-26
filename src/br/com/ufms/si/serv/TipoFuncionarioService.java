package br.com.ufms.si.serv;

import br.com.ufms.si.model.TipoFuncionario;
import br.com.ufms.si.serv.TipoFuncionarioService.TipoFuncionarioSearch;

public interface TipoFuncionarioService extends AbstractService<TipoFuncionario, TipoFuncionarioSearch> {

	public interface TipoFuncionarioSearch {

		String getTermo();

	}

}
