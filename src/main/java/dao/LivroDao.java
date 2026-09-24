package dao;

import entities.Livro;

import java.util.List;

public interface LivroDao {
    void insert(Livro obj);

    void update(Livro obj);

    void deleteById(Integer id);

    Livro findById(Integer id);

    List<Livro> findAll();
}
