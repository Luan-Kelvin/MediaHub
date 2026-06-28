package com.LkDev.MediaHub.Books.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class BookMenu {
    private Scanner input = new Scanner(System.in);
    private final BookService bookService;

    public void displayMenu(){
        int resp = 1;

       while (resp != 0){
           System.out.println("******************** MUSIC MENU ********************");
           System.out.println("[ 1 ] -> ADICIONAR NOVO LIVRO.");
           System.out.println("[ 2 ] -> ADICIONAR NOVO AUTOR.");
           System.out.println("[ 3 ] -> BUSCAR LIVRO EXISTENTE.");
           System.out.println("[ 4 ] -> BUSCAR LIVRO POR TRECHO.");
           System.out.println("[ 5 ] -> BUSCAR LIVRO DE AUTOR.");
           System.out.println("[ 6 ] -> LISTAR LIVROS CADASTRADAS.");
           System.out.println("[ 7 ] -> LISTAR AUTORES CADASTRADOS.");
           System.out.println("[ 8 ] -> VER LIVRO COM MAIS EDIÇÕES.");
           System.out.println("[ 9 ] -> VER AUTOR COM MAIS EDIÇÕES.");
           System.out.println("[ 0 ] -> SAIR.");
           System.out.println("-----------------------------------------------------");
           System.out.println("Escolha uma das opções acima: ");
           resp = Integer.parseInt(input.nextLine());
           System.out.println("*****************************************************");

           switch (resp){
               case 1 -> {
                   System.out.println("Digite o titulo do livro para cadastrar: ");
                   String tituloLivro = input.nextLine();

                   bookService.addBook(tituloLivro);
               }

               case 2 -> {
                   System.out.println("Digite o nome do Autor: ");
                   String nomeAutor = input.nextLine();

                   bookService.addAuthor(nomeAutor);
               }
           }
       }
    }
}
