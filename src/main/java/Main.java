import db.DB;
import entities.Livro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
         Connection conn = null;
         PreparedStatement st = null;

        Livro [] livros = {
                new Livro("Dom Casmurro", "Machado de Assis", 1899),
                new Livro("O Cortiço", "Aluísio Azevedo", 1890),
                new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881)
        };

        String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = DB.getConnection().prepareStatement(sql)) {

            for (Livro livro : livros){
                stmt.setString(1, livro.titulo);
                stmt.setString(2,livro.autor);
                stmt.setInt(3,livro.ano);
                stmt.addBatch();
            }

            int[] linhasInseridas = stmt.executeBatch();
            System.out.println(linhasInseridas.length + " registro(s) inserido(s) com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou inserir dados:");
            e.printStackTrace();
        }
    }
}
