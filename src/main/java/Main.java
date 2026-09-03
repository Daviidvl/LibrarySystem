import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/librarySDB";
        String usuario = "root";
        String senha = "Senha5050@!#"; // como se fosse o "login" com o bd passando o endereço do bd user e senha

        String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)"; // insere um livro na tabela livros

        try (Connection conn = DriverManager.getConnection(url, usuario, senha); // conexão do java com sql dentro de um "tente a conexão"
             PreparedStatement stmt = conn.prepareStatement(sql)) { // prepare para ser executado com a variavel sql

            stmt.setString(1, "Dom Casmurro");
            stmt.setString(2, "Machado de Assis");
            stmt.setInt(3, 1899); // passando os parametros para ficar no lugar de ? ? ? da string

            int linhasInseridas = stmt.executeUpdate();
            System.out.println(linhasInseridas + " registro(s) inserido(s) com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou inserir dados:");
            e.printStackTrace();
        }
    }
}
