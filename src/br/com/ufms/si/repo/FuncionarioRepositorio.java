package br.com.ufms.si.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufms.si.model.Endereco;
import br.com.ufms.si.model.Funcionario;

public class FuncionarioRepositorio {

	public void create(Connection conn, Funcionario entity) {
		String sqlInsert = "INSERT INTO FUNCIONARIO (nome, nascimento, email, celular, endereco, cpf, matricula, senha, situacao, tipo_Funcionario) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getNome());
			stm.setDate(2, entity.getNascimento());
			stm.setString(3, entity.getEmail());
			stm.setString(4, entity.getCelular());
			stm.setInt(5, entity.getEndereco().getId());
			stm.setString(6, entity.getCpf());
			stm.setString(7, entity.getMatricula());
			stm.setString(8, entity.getSenha());
			stm.setBoolean(9, entity.getSituacao());
			stm.setObject(10, null);
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

	public Funcionario update(Connection conn, Funcionario entity) {
		String sqlInsert = "UPDATE FUNCIONARIO SET nome = ?, nascimento =?, email=?, celular=?, endereco=?, cpf=?,  matricula=?, senha=?, situacao=?, tipoFuncionario=? WHERE id = ?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, entity.getNome());
			stm.setDate(2, entity.getNascimento());
			stm.setString(3, entity.getEmail());
			stm.setString(4, entity.getCelular());
			stm.setObject(5, entity.getEndereco());
			stm.setString(6, entity.getCpf());
			stm.setString(7, entity.getMatricula());
			stm.setString(8, entity.getSenha());
			stm.setBoolean(9, entity.getSituacao());
			stm.setObject(10, entity.getTipoFuncionario());
			stm.setLong(11, entity.getId());
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

	public Funcionario load(Connection conn, Integer id) {
		Funcionario funcionario = new Funcionario();
		String sqlSelect = "SELECT * FROM FUNCIONARIO WHERE id = ?";

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

		return funcionario;

	}

	public List<Funcionario> search(Connection conn, Integer codigo) {
		List<Funcionario> funcionarios = new ArrayList<>();
		String sqlSelect = "SELECT * FROM FUNCIONARIO";
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
				Funcionario funcionario = new Funcionario();
				// TODO
				funcionarios.add(funcionario);
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
		return funcionarios;
	}

	public void delete(Connection conn, Long id) {
		String sqlSelect = "DELETE FROM FUNCIONARIO WHERE id = ?";
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

	public List<Funcionario> loadAll(Connection conn) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String sqlSelect = "SELECT * FROM FUNCIONARIO";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {

				Funcionario funcionario = new Funcionario();
				// TODO
				funcionarios.add(funcionario);
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
		return funcionarios;
	}

	public Integer loadMax(Connection conn) {
		Integer id = 0;
		String sqlSelect = "SELECT MAX(id) as id FROM Funcionario";
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
