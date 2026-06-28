package com.LkDev.MediaHub.Books.Services;

import com.LkDev.MediaHub.Api.ConsumeApi;
import com.LkDev.MediaHub.Books.DTOs.LivroDTO;
import com.LkDev.MediaHub.Books.DTOs.MainDTO;
import com.LkDev.MediaHub.Books.Entity.Book;
import com.LkDev.MediaHub.Books.Repository.RepositoryBook;
import com.LkDev.MediaHub.Books.Repository.RespositoryAuthor;
import com.LkDev.MediaHub.Exception.BookAlreadyExistsExcepiton;
import com.LkDev.MediaHub.GeneralService.DTOConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class BookService {
    private Scanner input = new Scanner(System.in);
    private final ObjectMapper mapper;
    private final ConsumeApi consumeApi;
    private final DTOConverter dtoConverter;
    private final RepositoryBook repositoryBook;
    private final RespositoryAuthor respositoryAuthor;

    public void addBook(String nameBook){
        Optional<Book> bookRepo = repositoryBook.findByTitleIgnoreCase(nameBook);

        if (bookRepo.isPresent()){
            throw new BookAlreadyExistsExcepiton("ERRO! Livro "+nameBook+" ja está cadastrado.");
        }

       try {
           String endereco = "https://openlibrary.org/search.json?title="+nameBook.trim().replace(" ", "+").toLowerCase();

           String json = consumeApi.makeRequest(endereco);

           MainDTO mainDTO = mapper.readValue(json, MainDTO.class);

           List<LivroDTO> dtos = mainDTO.docs();

           AtomicInteger cont = new AtomicInteger(1);
           System.out.println(">>>> LIVROS ENCONTRADOS: "+nameBook.toUpperCase()+" <<<<");
           dtos.forEach(dto -> {
               System.out.println("[ "+cont+" ]"+" -> "+dto.titulo()+", Autor: "+dto.nomeAutor()+".");
               cont.addAndGet(1);
           });
           System.out.println("--------------------------------------------------");
           System.out.println("Escolha uma das opções acima (Selecione número do índice).)");
           int escolhaLivro = Integer.parseInt(input.nextLine());

           Book book = dtoConverter.converterBook(dtos.get(escolhaLivro));

           repositoryBook.save(book);
           System.out.println("Livro "+book.getTitle()+" salvo com sucesso!");


       } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }

    }
}
