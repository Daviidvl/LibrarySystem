package dao.impl;

import dao.LivroDao;
import db.DB;
import db.DbException;
import entities.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDaoJDBC implements LivroDao {

    private Connection conn;

    public LivroDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Livro obj) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("INSERT INTO livros "
                    +"(titulo, autor, ano) "
                    +"VALUES "
                    +"(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getTitulo());
            st.setString(2, obj.getAutor());
            st.setInt(3,obj.getAno());
            int rowsAfected = st.executeUpdate();

            if (rowsAfected > 0){
                 rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            } else {
                throw new DbException("ERROR");
            }
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultset(rs);
        }
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
        PreparedStatement st = null;
        ResultSet rs = null ;
        try{
            st = conn.prepareStatement("SELECT * FROM livros "
                    +"ORDER BY titulo ");
            rs = st.executeQuery();

            List<Livro> list = new ArrayList<>();

            while (rs.next()){
                Livro obj = instantiateLivro(rs);
                list.add(obj);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
                DB.closeStatement(st);
                DB.closeResultset(rs);
        }
    }
}
