package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.Agenda;
import br.com.ufms.si.repo.AgendaRepositorio;
import br.com.ufms.si.serv.AgendaService;

public class AgendaServiceImp implements AgendaService {

	Connection conn = null;
	Conexao bd;

	AgendaRepositorio repositorio;

	public AgendaServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new AgendaRepositorio();
	}

	@Override
	public void create(Agenda entity) {
		repositorio.create(conn, entity);
	}

	@Override
	public Agenda update(Agenda entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public Agenda load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<Agenda> search(AgendaSearch search) {
		return repositorio.search(conn, search.getEvento(), search.getDateInicial(), search.getDataFinal());
	}

	@Override
	public List<Agenda> loadAll() {
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
