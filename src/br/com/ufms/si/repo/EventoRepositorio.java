package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.Cliente;
import br.com.ufms.si.model.Endereco;
import br.com.ufms.si.model.Evento;

public class EventoRepositorio {

	public void create(Connection conn, Evento entity) {
		String sqlInsert = "INSERT INTO EVENTO (quantidadeConvidados, local, cliente, valor) VALUES (?,?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, entity.getQuantidadeConvidados());
			stm.setObject(2, entity.getLocal());
			stm.setObject(3, entity.getCliente());
			stm.setBigDecimal(4, entity.getValor());
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

	public Evento update(Connection conn, Evento entity) {
		String sqlInsert = "UPDATE Evento SET quantidadeConvidados = ?, local=?, cliente=?, valor=? WHERE id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, entity.getQuantidadeConvidados());
			stm.setObject(2, entity.getLocal());
			stm.setObject(3, entity.getCliente());
			stm.setBigDecimal(4, entity.getValor());
			stm.setLong(5, entity.getId());
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

	public Evento load(Connection conn, Integer id) {
		Evento evento = new Evento();
		String sqlSelect = "SELECT * FROM Evento WHERE id = ?";

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

		return evento;

	}

	public List<Evento> search(Connection conn, Endereco local, Cliente cliente) {
		List<Evento> eventos = new ArrayList<Evento>();
		String sqlSelect = "SELECT * FROM Evento";
		String busca = " WHERE ";

		int localSearch = 0;
		int clienteSearch = 0;

		int count = 0;
		if (local != null) {
			count++;
			localSearch = count;
			busca.concat(" local = ?");
		}
		if (cliente != null) {
			count++;
			if (count > 1)
				busca.concat("and");
			clienteSearch = count;
			busca.concat(" cliente = ?");
		}

		if (count > 1)
			sqlSelect.concat(busca);

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			if (localSearch > 0)
				stm.setObject(localSearch, local);
			if (clienteSearch > 0)
				stm.setObject(clienteSearch, cliente);
			rs = stm.executeQuery();
			while (rs.next()) {
				Evento evento = new Evento();
				// TODO
				eventos.add(evento);
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
		return eventos;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM Evento WHERE id = ?";
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

	public List<Evento> loadAll(Connection conn) {
		List<Evento> eventos = new ArrayList<Evento>();
		String sqlSelect = "SELECT * FROM Evento";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				Evento evento = new Evento();
				// TODO
				eventos.add(evento);
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
		return eventos;
	}
	
	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM Evento";
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
