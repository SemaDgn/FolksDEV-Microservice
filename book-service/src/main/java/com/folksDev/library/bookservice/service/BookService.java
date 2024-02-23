package com.folksDev.library.bookservice.service;

import com.folksDev.library.bookservice.dto.BookDto;
import com.folksDev.library.bookservice.dto.BookIdDto;
import com.folksDev.library.bookservice.exception.BookNotFoundException;
import com.folksDev.library.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBook() {
        return bookRepository.findAll().stream().map(e -> BookDto.convert(
                        e.getId(), e.getTitle(), e.getBookYear(),e.getAuthor(), e.getPressName(), e.getIsbn()))
                .collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn)
    {

        return bookRepository.findBookByIsbn(isbn)
                .stream()
                .map(e -> BookIdDto.convert(e.getId(), e.getIsbn()))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn : " + isbn));

    }
    public  BookDto findBookDetailsByID(String id)
    {
        return  bookRepository.findBookById(id)
                .stream()
                .map(book -> BookDto.convert(book.getId(), book.getTitle(), book.getBookYear(),book.getAuthor(),book.getPressName(),book.getIsbn()))
                .findFirst()
                .orElseThrow(()-> new BookNotFoundException("Book  could not found by id :"+id));

    }
}
