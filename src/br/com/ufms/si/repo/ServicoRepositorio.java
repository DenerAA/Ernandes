package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.Servico;
import br.com.ufms.si.model.Evento;

public class ServicoRepositorio {

	public void create(Connection conn, Servico entity) {
		String sqlInsert = "INSERT INTO Servico (tipo, valor, descricao) VALUES (?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getTipo());
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

	public Servico update(Connection conn, Servico entity) {
		String sqlInsert = "UPDATE Servico SET tipo=?, valor=?, descricao=? WHERE Servico.id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getTipo());
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

	public Servico load(Connection conn, Integer id) {
		Servico servico = new Servico();
		String sqlSelect = "SELECT * FROM Servico WHERE id = ?";

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

		return servico;

	}

	public List<Servico> search(Connection conn, String tipo, String descricao) {
		List<Servico> servicos = new ArrayList<Servico>();
		String sqlSelect = "SELECT * FROM Servico";
		String busca = " WHERE ";

		int tipoSearch = 0;
		int descricaoSearch = 0;

		int count = 0;
		if (tipo != null) {
			count++;
			tipoSearch = count;
			busca.concat(" tipo like ?");
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
			if (tipoSearch > 0)
				stm.setString(tipoSearch, tipo);
			if (descricaoSearch > 0)
				stm.setString(descricaoSearch, descricao);
			rs = stm.executeQuery();
			while (rs.next()) {
				Servico servico = new Servico();
				// TODO
				servicos.add(servico);
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
		return servicos;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM Servico WHERE id = ?";
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

	public List<Servico> loadAll(Connection conn) {
		List<Servico> servicos = new ArrayList<Servico>();
		String sqlSelect = "SELECT * FROM Servico";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				Servico servico = new Servico();
				// TODO
				servicos.add(servico);
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
		return servicos;
	}
	
	public Integer loadMax(Connection conn) {
		Integer id =0;
		String sqlSelect = "SELECT MAX(id) as id FROM Servico";
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
