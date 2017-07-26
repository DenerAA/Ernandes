package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.Cliente;
import br.com.ufms.si.repo.ClienteRepositorio;
import br.com.ufms.si.serv.ClienteService;

public class ClienteServiceImp implements ClienteService {

	Connection conn = null;
	Conexao bd;

	ClienteRepositorio repositorio;

	public ClienteServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new ClienteRepositorio();
	}

	@Override
	public void create(Cliente entity) {
		repositorio.create(conn, entity);
	}

	@Override
	public Cliente update(Cliente entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public Cliente load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<Cliente> search(ClienteSearch search) {
		return repositorio.search(conn, search.getCodigo());
	}

	@Override
	public List<Cliente> loadAll() {
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
