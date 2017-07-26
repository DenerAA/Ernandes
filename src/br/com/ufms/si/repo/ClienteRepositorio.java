package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.Agenda;
import br.com.ufms.si.model.Cliente;
import br.com.ufms.si.model.Cliente;
import br.com.ufms.si.model.Evento;

public class ClienteRepositorio {

	public void create(Connection conn, Cliente entity) {
		String sqlInsert = "INSERT INTO CLIENTE (nome, nascimento, email, celular, endereco, cpf, codigo) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getNome());
			stm.setDate(2, entity.getNascimento());
			stm.setString(3, entity.getEmail());
			stm.setString(4, entity.getCelular());
			stm.setObject(5, entity.getEndereco());
			stm.setString(6, entity.getCpf());
			stm.setInt(7, entity.getCodigo());
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

	public Cliente update(Connection conn, Cliente entity) {
		String sqlInsert = "UPDATE CLIENTE SET nome = ?, nascimento =?, email=?, celular=?, endereco=?, cpf=?, codigo=? WHERE id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getNome());
			stm.setDate(2, entity.getNascimento());
			stm.setString(3, entity.getEmail());
			stm.setString(4, entity.getCelular());
			stm.setObject(5, entity.getEndereco());
			stm.setString(6, entity.getCpf());
			stm.setInt(7, entity.getCodigo());
			stm.setLong(8, entity.getId());
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

	public Cliente load(Connection conn, Integer id) {
		Cliente cliente = new Cliente();
		String sqlSelect = "SELECT * FROM CLIENTE WHERE id = ?";

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

		return cliente;

	}

	public List<Cliente> search(Connection conn, Integer codigo) {
		List<Cliente> clientes = new ArrayList<>();
		String sqlSelect = "SELECT * FROM CLIENTE";
		String busca = " WHERE ";

		int codigoSearch = 0;

		int count = 0;
		if (codigo != null) {
			count++;
			codigoSearch = count;
			busca.concat(" codigo = ?");
		}

		if (count > 1)
			sqlSelect.concat(busca);

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			if (codigoSearch > 0)
				stm.setObject(codigoSearch, codigo);
			rs = stm.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				// TODO
				clientes.add(cliente);
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
		return clientes;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM CLIENTE WHERE id = ?";
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

	public List<Cliente> loadAll(Connection conn) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sqlSelect = "SELECT * FROM CLIENTE";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				Cliente cliente = new Cliente();
				// TODO
				clientes.add(cliente);
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
		return clientes;
	}

	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM Cliente";
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
