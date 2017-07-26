package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.TipoFuncionario;

public class TipoFuncionarioRepositorio {

	public void create(Connection conn, TipoFuncionario entity) {
		String sqlInsert = "INSERT INTO TipoFuncionario (termo) VALUES (?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getTermo());
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

	public TipoFuncionario update(Connection conn, TipoFuncionario entity) {
		String sqlInsert = "UPDATE TipoFuncionario SET termo=? WHERE id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getTermo());
			stm.setLong(2, entity.getId());
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

	public TipoFuncionario load(Connection conn, Integer id) {
		TipoFuncionario tipoFuncionario = new TipoFuncionario();
		String sqlSelect = "SELECT * FROM TipoFuncionario WHERE id = ?";

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

		return tipoFuncionario;

	}

	public List<TipoFuncionario> search(Connection conn, String termo) {
		List<TipoFuncionario> tipoFuncionarios = new ArrayList<TipoFuncionario>();
		String sqlSelect = "SELECT * FROM TipoFuncionario";
		String busca = " WHERE ";

		int termoSearch = 0;

		int count = 0;
		if (termo != null) {
			count++;
			termoSearch = count;
			busca.concat(" termo like ?");
		}

		if (count > 1)
			sqlSelect.concat(busca);

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			if (termoSearch > 0)
				stm.setString(termoSearch, termo);
			rs = stm.executeQuery();
			while (rs.next()) {
				TipoFuncionario tipoFuncionario = new TipoFuncionario();
				// TODO
				tipoFuncionarios.add(tipoFuncionario);
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
		return tipoFuncionarios;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM TipoFuncionario WHERE id = ?";
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

	public List<TipoFuncionario> loadAll(Connection conn) {
		List<TipoFuncionario> tipoFuncionarios = new ArrayList<TipoFuncionario>();
		String sqlSelect = "SELECT * FROM TipoFuncionario";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				TipoFuncionario tipoFuncionario = new TipoFuncionario();
				// TODO
				tipoFuncionarios.add(tipoFuncionario);
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
		return tipoFuncionarios;
	}

	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM TipoFuncionario";
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
