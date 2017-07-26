package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.TipoFuncionario;
import br.com.ufms.si.repo.TipoFuncionarioRepositorio;
import br.com.ufms.si.serv.TipoFuncionarioService;

public class TipoFuncionarioServiceImp implements TipoFuncionarioService {

	Connection conn = null;
	Conexao bd;

	TipoFuncionarioRepositorio repositorio;

	public TipoFuncionarioServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new TipoFuncionarioRepositorio();
	}

	@Override
	public void create(TipoFuncionario entity) {
		repositorio.create(conn, entity);
	}

	@Override
	public TipoFuncionario update(TipoFuncionario entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public TipoFuncionario load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<TipoFuncionario> search(TipoFuncionarioSearch search) {
		return repositorio.search(conn, search.getTermo());
	}

	@Override
	public List<TipoFuncionario> loadAll() {
		return repositorio.loadAll(conn);
	}

	@Override
	public void delete(Long id) {
		repositorio.delete(conn, id);
	}

	@Override
	public Integer loadMax() {
		return repositorio.loadMax(conn);
	}

}
