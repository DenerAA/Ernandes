package br.com.ufms.si.servImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ufms.si.conf.Conexao;
import br.com.ufms.si.model.Funcionario;
import br.com.ufms.si.repo.FuncionarioRepositorio;
import br.com.ufms.si.serv.FuncionarioService;

public class FuncionarioServiceImp implements FuncionarioService {

	Connection conn = null;
	Conexao bd;

	FuncionarioRepositorio repositorio;

	EnderecoServiceImp enderecoService;

	public FuncionarioServiceImp() throws SQLException {
		bd = new Conexao();
		conn = bd.obtemConexao();
		conn.setAutoCommit(false);
		repositorio = new FuncionarioRepositorio();
		enderecoService = new EnderecoServiceImp();
	}

	@Override
	public void create(Funcionario entity) {
		enderecoService.create(entity.getEndereco());
		entity.getEndereco().setId(enderecoService.loadMax());
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repositorio.create(conn, entity);
	}

	@Override
	public Funcionario update(Funcionario entity) {
		return repositorio.update(conn, entity);
	}

	@Override
	public Funcionario load(Integer id) {
		return repositorio.load(conn, id);
	}

	@Override
	public List<Funcionario> search(FuncionarioSearch search) {
		return repositorio.search(conn, search.getCodigo());
	}

	@Override
	public List<Funcionario> loadAll() {
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
