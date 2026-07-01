package com.LkDev.MediaHub.Books.Repository;

import com.LkDev.MediaHub.Books.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryBook extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleIgnoreCase(String title);

    Optional<Book> findByTitleIgnoreCaseAndAuthorAuthorKey(String titulo, String authorKey);

    List<Book> findByTitleContainingIgnoreCase(String trecho);

    boolean existsByTitleIgnoreCase(String titulo);
}
