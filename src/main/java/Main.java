import library.entities.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Books> livros = new ArrayList<>();
        livros.add(new Books("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia"));
        livros.add(new Books("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia"));
        livros.add(new Books("Dom Casmurro", "Machado de Assis", "Romance"));

        System.out.println("Digite o nome do livro, que deseja alugar: ");
        String nome = sc.nextLine();

        boolean encontrado = false;

        for (Books livro : livros){
            if (livro.getNome().equalsIgnoreCase(nome)){
                System.out.println("Livro encontrado! ");
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Genero: " + livro.getGenero());
                encontrado = true;
                break;
            }
        }

        if (!encontrado){
            System.out.println("Livro não encontrado");
        }
        sc.close();
    }
}
