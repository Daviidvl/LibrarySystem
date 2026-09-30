import dao.DaoFactory;
import dao.LivroDao;
import entities.Livro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LivroDao livroDao = DaoFactory.createLivroDao();

        //System.out.println("FindByID");
        //Livro livro = livroDao.findById(4);
        //System.out.println(livro);

        //System.out.println("FindAll");
        //List<Livro> livList = livroDao.findAll();
        //for (Livro obj : livList){
            //System.out.println(obj);
        //}

       // System.out.println("Insert");
       // Livro novoLivro = new Livro();
       // novoLivro.setTitulo("Dom Casmurro");
       // novoLivro.setAutor("Machado de Assis");
       // novoLivro.setAno(1899);
       // livroDao.insert(novoLivro);
       // System.out.println("Inserido com sucesso! Novo id: " + novoLivro.getId());

        //System.out.println("Delete");
        //System.out.print("Enter id for delete test: ");
        //int livId = sc.nextInt();
        //livroDao.deleteById(livId);
        //System.out.println("Deletado com sucesso!");

        System.out.println("Update");
        Livro liv = livroDao.findById(7);
        liv.setTitulo("O carniça");
        liv.setAutor("Davizera");
        livroDao.update(liv);
        System.out.println("Update complete! ");
    }
}
