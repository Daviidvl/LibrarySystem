import db.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarLivro {
    public static void main(String[] args) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano = ? WHERE id = ?";

        try(PreparedStatement stmt = DB.getConnection().prepareStatement(sql)){
            stmt.setString(1, "Dom Casmurro (Edição Revisada)");
            stmt.setString(2, "Machado de Assis");
            stmt.setInt(3, 1900);
            stmt.setInt(4, 1);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0){
                System.out.println(linhasAfetadas + "registro(s) atualizado(s) com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado nesse id");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados: ");
            e.printStackTrace();
        } finally {
            DB.closeConnection();
        }
    }
}
