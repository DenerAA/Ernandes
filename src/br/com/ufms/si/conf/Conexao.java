package br.com.ufms.si.conf;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	// Carrega driver JDBC
    public Conexao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
 
    //Obtem conexao com banco de dados
    public Connection obtemConexao() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
    }
}
