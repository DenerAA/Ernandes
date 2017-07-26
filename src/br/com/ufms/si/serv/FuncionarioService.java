package br.com.ufms.si.serv;

import br.com.ufms.si.model.Funcionario;
import br.com.ufms.si.serv.FuncionarioService.FuncionarioSearch;

public interface FuncionarioService extends AbstractService<Funcionario, FuncionarioSearch> {

	public interface FuncionarioSearch {

		Integer getCodigo();
	}

}
