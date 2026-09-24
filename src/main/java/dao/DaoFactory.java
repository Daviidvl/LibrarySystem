package dao;

import dao.impl.LivroDaoJDBC;
import db.DB;

public class DaoFactory {
    public static LivroDao createLivroDao(){
        return new LivroDaoJDBC(DB.getConnection());
    }
}
