package library.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    private static final String URL = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/libary_system");
    private static final String USER = System.getenv().getOrDefault("DB_USER", "root");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        if (PASSWORD == null) {
            throw new IllegalStateException("Variavel de ambiente DB_PASSWORD nao foi definida");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            criarTabelaSeNaoExistir(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

    private static void criarTabelaSeNaoExistir(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS books (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(255) NOT NULL,
                    autor VARCHAR(255) NOT NULL,
                    genero VARCHAR(100),
                    disponivel BOOLEAN DEFAULT TRUE
                )
                """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }
}