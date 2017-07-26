package br.com.ufms.si.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.model.Funcionario;
import br.com.ufms.si.serv.FuncionarioService.FuncionarioSearch;
import br.com.ufms.si.servImp.FuncionarioServiceImp;

public class FuncionarioResource {

	private Integer codigo;

	private FuncionarioServiceImp service;

	public FuncionarioResource() throws SQLException {
		service = new FuncionarioServiceImp();
	}

	public FuncionarioResource(Integer codigo) {
		this.codigo = codigo;
	}

	public Funcionario load(Integer id) {
		return service.load(id);
	}

	public void create(Funcionario entity) {
		service.create(entity);
	}

	public Funcionario update(Funcionario entity) {
		return service.update(entity);
	};

	public List<Funcionario> search() {
		Search search = new Search();
		return service.search(search);
	}

	List<Funcionario> loadAll() {
		return service.loadAll();
	}

	public void delete(Long id) {
		service.delete(id);
	};
	
	public Integer loadMax() {
		return service.loadMax();
	}

	public class Search implements FuncionarioSearch {

		@Override
		public Integer getCodigo() {
			// TODO Auto-generated method stub
			return codigo;
		}

	}

}
