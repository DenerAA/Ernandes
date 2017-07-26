package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.Evento;
import br.com.ufms.si.repo.EventoRepositorio;
import br.com.ufms.si.serv.EventoService;

public class EventoServiceImp implements EventoService {

	Connection conn = null;
	Conexao bd;

	EventoRepositorio repositorio;

	public EventoServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new EventoRepositorio();
	}

	@Override
	public void create(Evento entity) {
		repositorio.create(conn, entity);
	}

	@Override
	public Evento update(Evento entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public Evento load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<Evento> search(EventoSearch search) {
		return repositorio.search(conn, search.getLocal(), search.getCliente());
	}

	@Override
	public List<Evento> loadAll() {
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
