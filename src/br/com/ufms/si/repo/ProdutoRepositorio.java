package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.Produto;
import br.com.ufms.si.model.Evento;

public class ProdutoRepositorio {

	public void create(Connection conn, Produto entity) {
		String sqlInsert = "INSERT INTO Produto (nome, valor, descricao) VALUES (?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getNome());
			stm.setBigDecimal(2, entity.getValor());
			stm.setString(3, entity.getDescricao());
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

	public Produto update(Connection conn, Produto entity) {
		String sqlInsert = "UPDATE Produto SET nome=?, valor=?, descricao=? WHERE Produto.id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getNome());
			stm.setBigDecimal(2, entity.getValor());
			stm.setString(3, entity.getDescricao());
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

	public Produto load(Connection conn, Integer id) {
		Produto produto = new Produto();
		String sqlSelect = "SELECT * FROM Produto WHERE id = ?";

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

		return produto;

	}

	public List<Produto> search(Connection conn, String nome, String descricao) {
		List<Produto> produtos = new ArrayList<Produto>();
		String sqlSelect = "SELECT * FROM Produto";
		String busca = " WHERE ";

		int nomeSearch = 0;
		int descricaoSearch = 0;

		int count = 0;
		if (nome != null) {
			count++;
			nomeSearch = count;
			busca.concat(" nome like ?");
		}
		if (descricao != null) {
			count++;
			if (count > 1)
				busca.concat("and");
			descricaoSearch = count;
			busca.concat(" descricao like ?");
		}

		if (count > 1)
			sqlSelect.concat(busca);

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			if (nomeSearch > 0)
				stm.setString(nomeSearch, nome);
			if (descricaoSearch > 0)
				stm.setString(descricaoSearch, descricao + "%");

			rs = stm.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				// TODO
				produtos.add(produto);
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
		return produtos;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM Produto WHERE id = ?";
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

	public List<Produto> loadAll(Connection conn) {
		List<Produto> produtos = new ArrayList<Produto>();
		String sqlSelect = "SELECT * FROM Produto";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				Produto produto = new Produto();
				// TODO
				produtos.add(produto);
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
		return produtos;
	}

	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM Produto";
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
