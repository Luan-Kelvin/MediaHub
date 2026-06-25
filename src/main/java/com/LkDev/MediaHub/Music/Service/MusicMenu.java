package com.LkDev.MediaHub.Music.Service;

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
            System.out.println("[ 5 ] -> BUSCAR MÚSICAS DE ARTISTA.");
            System.out.println("[ 6 ] -> LISTAR MÚSICAS CADASTRADAS.");
            System.out.println("[ 7 ] -> LISTAR ARTISTAS CADASTRADOS.");
            System.out.println("[ 8 ] -> VER MÚSICA MAIS OUVIDA.");
            System.out.println("[ 9 ] -> VER ARTISTA MAIS OUVIDO.");
            System.out.println("[ 0 ] -> SAIR.");
            System.out.println("-----------------------------------------------------");
            System.out.println("Escolha uma das opções acima: ");
            resp = Integer.parseInt(input.nextLine());
            System.out.println("*****************************************************");

            switch (resp){
                case 1 -> {
                    System.out.println("Digite o nome da música.");
                    String nomeMusic = input.nextLine();

                    System.out.println("Digite nome Do Artista");
                    String nomeArtist = input.nextLine();

                    musicService.addMusic(nomeMusic, nomeArtist);
                }

                case 2 -> {
                    System.out.println("Digite o nome do artista: ");
                    String nomeArtist = input.nextLine();

                    artistService.addArtist(nomeArtist);
                }

                case 3 -> {
                    System.out.println("Digite o nome da músicas");
                    String nameMusic = input.nextLine();

                    musicService.SearchMusicInDataBase(nameMusic);
                }

                case 4 -> {
                    System.out.println("Digite um trecho do nome da música: ");
                    String trecho = input.nextLine();

                    musicService.SearchMusicBySnippet(trecho);
                }

                case 5 -> {
                    System.out.println("Digite o nome do artista.");
                    String nomeArtist = input.nextLine();

                    musicService.SearchForAnArtistSong(nomeArtist);
                }

                case 6 -> musicService.listMusicsInDataBAse();

                case 7 -> musicService.listArtistsInDataBase();

                case 8 -> musicService.showMostPlayedsong();

                case 9 -> musicService.showMostArtists();

                case 0 -> System.out.println("Encerrando programa...");

                default -> System.out.println("Escolha uma opção válida.");
            }
        }
    }
}
