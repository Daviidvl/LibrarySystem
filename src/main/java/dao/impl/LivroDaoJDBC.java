package dao.impl;

import dao.LivroDao;
import db.DB;
import db.DbException;
import entities.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LivroDaoJDBC implements LivroDao {

    private Connection conn;

    public LivroDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Livro obj) {

    }

    @Override
    public void update(Livro obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Livro findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM livros WHERE id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()){
                Livro obj = instantiateLivro(rs);
                return obj;
            }
            return null;
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultset(rs);
            DB.closeStatement(st);

        }
    }

    private  Livro instantiateLivro(ResultSet rs) throws SQLException{
        Livro liv = new Livro();
        liv.setId(rs.getInt("id"));
        liv.setTitulo(rs.getString("titulo"));
        liv.setAutor(rs.getString("autor"));
        liv.setAno(rs.getInt("ano"));
        return liv;
    }

    @Override
    public List<Livro> findAll() {
        return List.of();
    }
}
