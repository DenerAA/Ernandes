package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.Endereco;
import br.com.ufms.si.repo.EnderecoRepositorio;
import br.com.ufms.si.serv.EnderecoService;

public class EnderecoServiceImp implements EnderecoService {

	Connection conn = null;
	Conexao bd;

	EnderecoRepositorio repositorio;

	public EnderecoServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new EnderecoRepositorio();
	}

	@Override
	public void create(Endereco entity) {
		repositorio.create(conn, entity);
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Endereco update(Endereco entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public Endereco load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<Endereco> search(EnderecoSearch search) {
		return null;
	}

	@Override
	public List<Endereco> loadAll() {
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
