import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LerLivros {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT * FROM livros" );

            while (rs.next()){
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("titulo") + " | " +
                        rs.getString("autor") + " | " +
                        rs.getInt("ano")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultset(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
