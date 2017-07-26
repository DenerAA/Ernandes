package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.Agenda;
import br.com.ufms.si.model.Evento;

public class AgendaRepositorio {

	public void create(Connection conn, Agenda entity) {
		String sqlInsert = "INSERT INTO AGENDA (data, evento) VALUES (?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setDate(1, entity.getData());
			stm.setObject(2, entity.getEvento());
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

	public Agenda update(Connection conn, Agenda entity) {
		String sqlInsert = "UPDATE Agenda SET evento = ?,data = ? WHERE Agenda.id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setObject(1, entity.getEvento());
			stm.setDate(2, entity.getData());
			stm.setLong(3, entity.getId());
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

	public Agenda load(Connection conn, Integer id) {
		Agenda agenda = new Agenda();
		String sqlSelect = "SELECT * FROM Agenda WHERE id = ?";

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

		return agenda;

	}

	public List<Agenda> search(Connection conn, Evento evento, Date dataInicial, Date dataFinal) {
		List<Agenda> agendas = new ArrayList<Agenda>();
		String sqlSelect = "SELECT * FROM Agenda";
		String busca = " WHERE ";

		int eventoSearch = 0;
		int dataInicialSearch = 0;
		int dataFinalSearch = 0;

		int count = 0;
		if (evento != null) {
			count++;
			eventoSearch = count;
			busca.concat(" evento = ?");
		}
		if (dataInicial != null) {
			count++;
			if (count > 1)
				busca.concat("and");
			dataInicialSearch = count;
			busca.concat(" data >= ?");
		}
		if (dataFinal != null) {
			count++;
			if (count > 1)
				busca.concat("and");
			dataFinalSearch = count;
			busca.concat(" data <= ?");
		}

		if (count > 1)
			sqlSelect.concat(busca);

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			if (eventoSearch > 0)
				stm.setObject(eventoSearch, evento);
			if (dataInicialSearch > 0)
				stm.setDate(dataInicialSearch, dataInicial);
			if (dataFinalSearch > 0)
				stm.setDate(dataFinalSearch, dataFinal);
			rs = stm.executeQuery();
			while (rs.next()) {
				Agenda agenda = new Agenda();
				// TODO
				agendas.add(agenda);
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
		return agendas;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM Agenda WHERE id = ?";
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

	public List<Agenda> loadAll(Connection conn) {
		List<Agenda> agendas = new ArrayList<Agenda>();
		String sqlSelect = "SELECT * FROM Agenda";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				Agenda agenda = new Agenda();
				// TODO
				agendas.add(agenda);
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
		return agendas;
	}

	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM Agenda";
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
