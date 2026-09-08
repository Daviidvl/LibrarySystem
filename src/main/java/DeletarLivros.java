import db.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeletarLivros {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o título a buscar: ");
        String titulo = sc.nextLine();

        Statement stConsulta = null;
        ResultSet rs = null;

        try {

            stConsulta = DB.getConnection().createStatement();
            rs = stConsulta.executeQuery(
                    "SELECT id, titulo, autor, ano FROM livros WHERE titulo = '" + titulo + "'"
            );

            System.out.println("Encontrados:");
            boolean encontrouAlgum = false;
            while (rs.next()) {
                encontrouAlgum = true;
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                " | " + rs.getString("titulo") +
                                " | " + rs.getString("autor") +
                                " | " + rs.getInt("ano")
                );
            }

            if (!encontrouAlgum) {
                System.out.println("Nenhum livro encontrado com esse título.");
                return;
            }

            // 2. Pergunta qual ID deletar
            System.out.print("Digite o ID do livro que deseja deletar: ");
            int id = sc.nextInt();

            // 3. Deleta pelo ID escolhido
            try (PreparedStatement stmtDelete = DB.getConnection().prepareStatement(
                    "DELETE FROM livros WHERE id = ?")) {
                stmtDelete.setInt(1, id);
                int linhasAfetadas = stmtDelete.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Livro deletado com sucesso!");
                } else {
                    System.out.println("Nenhum livro deletado — ID não encontrado.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultset(rs);
            DB.closeStatement(stConsulta);
            DB.closeConnection();
            sc.close();
        }
    }
}