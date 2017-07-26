package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.Cliente;
import br.com.ufms.si.model.Endereco;

public class EnderecoRepositorio {

	public void create(Connection conn, Endereco entity) {
		String sqlInsert = "INSERT INTO ENDERECO (rua, bairro, cidade, cep) VALUES (?,?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getRua());
			stm.setString(2, entity.getBairro());
			stm.setString(3, entity.getCidade());
			stm.setString(4, entity.getCep());
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

	public Endereco update(Connection conn, Endereco entity) {
		String sqlInsert = "UPDATE ENDERECO SET rua = ?, bairro=?, cidade=?, cep=? WHERE id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getRua());
			stm.setString(2, entity.getBairro());
			stm.setString(3, entity.getCidade());
			stm.setString(4, entity.getCep());
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

	public Endereco load(Connection conn, Integer id) {
		Endereco endereco = new Endereco();
		String sqlSelect = "SELECT * FROM ENDERECO WHERE id = ?";

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

		return endereco;

	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM ENDERECO WHERE id = ?";
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

	public List<Endereco> loadAll(Connection conn) {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		String sqlSelect = "SELECT * FROM ENDERECO";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				Endereco endereco = new Endereco();
				// TODO
				enderecos.add(endereco);
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
		return enderecos;
	}

	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM Endereco";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);

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
