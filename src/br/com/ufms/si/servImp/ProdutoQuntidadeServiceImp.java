package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.ProdutoQuantidade;
import br.com.ufms.si.repo.ProdutoQuantidadeRepositorio;
import br.com.ufms.si.serv.ProdutoQuantidadeService;

public class ProdutoQuntidadeServiceImp implements ProdutoQuantidadeService {

	Connection conn = null;
	Conexao bd;

	ProdutoQuantidadeRepositorio repositorio;

	public ProdutoQuntidadeServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new ProdutoQuantidadeRepositorio();
	}

	@Override
	public void create(ProdutoQuantidade entity) {
		repositorio.create(conn, entity);
	}

	@Override
	public ProdutoQuantidade update(ProdutoQuantidade entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public ProdutoQuantidade load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<ProdutoQuantidade> search(ProdutoQuantidadeSearch search) {
		return repositorio.search(conn, search.getEvento(), search.getProduto());
	}

	@Override
	public List<ProdutoQuantidade> loadAll() {
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
