package com.LkDev.MediaHub.Music.Service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service
@NoArgsConstructor
public class MusicMenu {
    private Scanner input = new Scanner(System.in);

    public void displayMenu() {
        int resp = 1;
        while (resp != 0) {
            System.out.println("******************** MUSIC MENU ********************");
            System.out.println("[ 1 ] -> ADICIONAR NOVA MÚSICA.");
            System.out.println("[ 2 ] -> ADICIONAR NOVO ARTISTA.");
            System.out.println("[ 3 ] -> BUSCAR MÚSICA EXISTENTE.");
            System.out.println("[ 4 ] -> BUSCAR MÚSICA POR TRECHO.");
            System.out.println("[ 5 ] -> BUSCAR MÚSICA POR ARTISTA.");
            System.out.println("[ 6 ] -> LISTAR MÚSICAS CADASTRADAS.");
            System.out.println("[ 7 ] -> LISTAR ARTISTAS CADASTRADOS.");
            System.out.println("[ 8 ] -> LISTAR MÚSICAS DE UM ARTISTA EXPECIFICO.");
            System.out.println("[ 9 ] -> VER MÚSICA MAIS OUVIDA.");
            System.out.println("[ 10 ] -> VER ARTISTA MAIS OUVIDO.");
            System.out.println("[ 0 ] -> SAIR.");
            System.out.println("-----------------------------------------------------");
            System.out.println("Escolha uma das opções acima: ");
            resp = Integer.parseInt(input.nextLine());
            System.out.println("*****************************************************");

            switch (resp){
                case 1 -> {

                }
            }
        }
    }
}
