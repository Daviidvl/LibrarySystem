import library.entities.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Books> book = new ArrayList<>();

        int opcao = 5;

        while (opcao != 3) {
            System.out.println("Digite a opção que deseja realizar a baixo");
            System.out.println("1. Cadastrar um livro ");
            System.out.println("2. Alugar um livro");
            System.out.println("3. Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.println("Digite nome do livro que deseja cadastrar: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o nome do autor: ");
                    String autor = sc.nextLine();
                    System.out.println("Digite o genero do livro: ");
                    String genero = sc.nextLine();

                    Books livros = new Books(nome, autor, genero);
                    book.add(livros);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o nome do livro, que deseja alugar: ");
                    nome = sc.nextLine();

                    boolean encontrado = false;

                    for (Books books : book) {
                        if (books.getNome().equalsIgnoreCase(nome)) {
                            System.out.println("Livro encontrado! ");
                            System.out.println("Autor: " + books.getAutor());
                            System.out.println("Genero: " + books.getGenero());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Livro não encontrado");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
        sc.close();
    }
}