package DAO.Generics.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory(Connection connection) {

    }

    public static Connection getConnection() throws SQLException {
        Connection result;
        if (connection == null) {
            connection = initConnection();
            result = connection;
        } else if (connection.isClosed()) {
            connection = initConnection();
            result = connection;
        } else {
            result = connection;
        }
        return result;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:15432/Vendas_online_2", "cadinhoaline@gmail.com", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

