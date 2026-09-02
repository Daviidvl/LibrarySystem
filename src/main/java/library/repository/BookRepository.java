package library.repository;

import library.entities.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    public void salvar(Books livro) {
        String sql = "INSERT INTO books (nome, autor, genero, disponivel) VALUES (?, ?, ?, TRUE)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getGenero());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro: " + e.getMessage(), e);
        }
    }

    public Optional<Books> buscarPorNome(String nome) {
        String sql = "SELECT * FROM books WHERE LOWER(nome) = LOWER(?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Books livro = new Books(
                        rs.getString("nome"),
                        rs.getString("autor"),
                        rs.getString("genero")
                );
                return Optional.of(livro);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livro: " + e.getMessage(), e);
        }
    }

    public List<Books> listarTodos() {
        String sql = "SELECT * FROM books";
        List<Books> livros = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                livros.add(new Books(
                        rs.getString("nome"),
                        rs.getString("autor"),
                        rs.getString("genero")
                ));
            }
            return livros;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros: " + e.getMessage(), e);
        }
    }
}