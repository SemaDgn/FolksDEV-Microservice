package com.folksDev.library.bookservice.repository;

import com.folksDev.library.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {

    Optional<Book> findBookByIsbn (String isbn);
    Optional<Book> findBookById (String id);
}
