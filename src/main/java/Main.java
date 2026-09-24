import dao.LivroDao;
import dao.impl.LivroDaoJDBC;
import db.DB;
import entities.Livro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        Livro[] livros = {
//                new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881, null)
//        };
//
//        String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";
//
//        try {
//            conn = DB.getConnection();
//            conn.setAutoCommit(false); // deliga o "salvar automático"
//            stmt = conn.prepareStatement(sql);
//
//            for (Livro livro : livros) {
//                stmt.setString(1, livro.titulo);
//                stmt.setString(2, livro.autor);
//                stmt.setInt(3, livro.ano);
//                stmt.addBatch();
//            }
//
//            int[] linhasInseridas = stmt.executeBatch();
//            conn.commit();
//            System.out.println(linhasInseridas.length + " registro(s) inserido(s) com sucesso!");
//
//        } catch (SQLException e) {
//            System.out.println("Erro ao conectar ou inserir dados:");
//            if (conn != null) {
//                try {
//                    conn.rollback();
//                } catch (SQLException e2) {
//                    e2.printStackTrace();
//                }
//            }
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.setAutoCommit(true);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            DB.closeStatement(stmt);
//            DB.closeConnection();
//        }

        LivroDao dao = new LivroDaoJDBC(DB.getConnection());

        Livro livro = dao.findById(4);
        System.out.println(livro);
    }
}
