package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.ProdutoQuantidade;
import br.com.ufms.si.model.Evento;
import br.com.ufms.si.model.Produto;

public class ProdutoQuantidadeRepositorio {

	public void create(Connection conn, ProdutoQuantidade entity) {
		String sqlInsert = "INSERT INTO ProdutoQuantidade (quantidade, evento, produto) VALUES (?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, entity.getQuantidade());
			stm.setObject(2, entity.getEvento());
			stm.setObject(3, entity.getProduto());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

	public ProdutoQuantidade update(Connection conn, ProdutoQuantidade entity) {
		String sqlInsert = "UPDATE ProdutoQuantidade SET quantidade=?, evento=?, produto=? WHERE id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, entity.getQuantidade());
			stm.setObject(2, entity.getEvento());
			stm.setObject(3, entity.getProduto());
			stm.setLong(4, entity.getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}

		return entity;
	}

	public ProdutoQuantidade load(Connection conn, Integer id) {
		ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade();
		String sqlSelect = "SELECT * FROM ProdutoQuantidade WHERE id = ?";

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);

			stm.setLong(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				// TODO

			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}

		return produtoQuantidade;

	}

	public List<ProdutoQuantidade> search(Connection conn, Evento evento, Produto produto) {
		List<ProdutoQuantidade> produtoQuantidades = new ArrayList<ProdutoQuantidade>();
		String sqlSelect = "SELECT * FROM ProdutoQuantidade";
		String busca = " WHERE ";

		int eventoSearch = 0;
		int produtoSearch = 0;

		int count = 0;
		if (evento != null) {
			count++;
			eventoSearch = count;
			busca.concat(" evento = ?");
		}
		if (produto != null) {
			count++;
			if (count > 1)
				busca.concat("and");
			produtoSearch = count;
			busca.concat(" produto = ?");
		}

		if (count > 1)
			sqlSelect.concat(busca);

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			if (eventoSearch > 0)
				stm.setObject(eventoSearch, evento);
			if (produtoSearch > 0)
				stm.setObject(produtoSearch, produto);

			rs = stm.executeQuery();
			while (rs.next()) {
				ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade();
				// TODO
				produtoQuantidades.add(produtoQuantidade);
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return produtoQuantidades;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM ProdutoQuantidade WHERE id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			stm.setLong(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

	public List<ProdutoQuantidade> loadAll(Connection conn) {
		List<ProdutoQuantidade> produtoQuantidades = new ArrayList<ProdutoQuantidade>();
		String sqlSelect = "SELECT * FROM ProdutoQuantidade";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade();
				// TODO
				produtoQuantidades.add(produtoQuantidade);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return produtoQuantidades;
	}

	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM ProdutoQuantidade";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {
				// TODO

			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return id;
	}

}
