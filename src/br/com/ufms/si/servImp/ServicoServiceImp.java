package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.Servico;
import br.com.ufms.si.repo.ServicoRepositorio;
import br.com.ufms.si.serv.ServicoService;

public class ServicoServiceImp implements ServicoService {

	Connection conn = null;
	Conexao bd;

	ServicoRepositorio repositorio;

	public ServicoServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new ServicoRepositorio();
	}

	@Override
	public void create(Servico entity) {
		repositorio.create(conn, entity);
	}

	@Override
	public Servico update(Servico entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public Servico load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<Servico> search(ServicoSearch search) {
		return repositorio.search(conn, search.getTipo(), search.getDescricao());
	}

	@Override
	public List<Servico> loadAll() {
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
