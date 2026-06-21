package com.LkDev.MediaHub.Music.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service
@RequiredArgsConstructor
public class MusicMenu {
    private Scanner input = new Scanner(System.in);
    private final MusicService musicService;
    private final ArtistService artistService;


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
                    System.out.println("Digite o nome da música.");
                    String nomeMusic = input.nextLine();

                    musicService.addMusic(nomeMusic);
                }

                case 2 -> {
                    System.out.println("Digite o nome do artista: ");
                    String nomeArtist = input.nextLine();

                    artistService.addArtist(nomeArtist);
                }
            }
        }
    }
}
