package com.LkDev.MediaHub.Menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class MainMenu {
     private Scanner input = new Scanner(System.in);

     public void displayMenu(){
         int resp = 1;

         while (resp != 0){
             System.out.println(">>>>>>>>>>>>>>> MAIN MENU <<<<<<<<<<<<<<<");
             System.out.println("[ 1 ] -> MÚSICAS");
             System.out.println("[ 2 ] -> LIVROS");
             System.out.println("[ 3 ] -> FILMES ");
             System.out.println("[ 4 ] -> SÉRIES");
             System.out.println("[ 0 ] -> SAIR");
             System.out.println("Escolha uma das opções acima: ");
             System.out.println("-----------------------------");
             resp = Integer.parseInt(input.nextLine());

             switch (resp){

             }
             System.out.println(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<");
         }
     }
}
