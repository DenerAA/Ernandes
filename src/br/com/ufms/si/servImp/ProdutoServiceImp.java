package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.Produto;
import br.com.ufms.si.repo.ProdutoRepositorio;
import br.com.ufms.si.serv.ProdutoService;

public class ProdutoServiceImp implements ProdutoService {

	Connection conn = null;
	Conexao bd;

	ProdutoRepositorio repositorio;

	public ProdutoServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new ProdutoRepositorio();
	}

	@Override
	public void create(Produto entity) {
		repositorio.create(conn, entity);
	}

	@Override
	public Produto update(Produto entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public Produto load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<Produto> search(ProdutoSearch search) {
		return repositorio.search(conn, search.getNome(), search.getDescricao());
	}

	@Override
	public List<Produto> loadAll() {
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
