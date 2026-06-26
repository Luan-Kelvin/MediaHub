package com.LkDev.MediaHub.Books.Repository;

import com.LkDev.MediaHub.Books.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RespositoryAuthor extends JpaRepository<Long, Author> {

    Optional<Author> findByAuthorNameIgnoreCase(String name);
}
