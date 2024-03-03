package com.folksDev.library.bookservice.controller;

import com.folksDev.library.bookservice.dto.BookDto;
import com.folksDev.library.bookservice.dto.BookIdDto;
import com.folksDev.library.bookservice.service.BookService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/book")
public class BookController {

    private final BookService bookService;
    Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook() {
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn) {
        logger.info("Book rrquested by isbn: " + isbn);
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id) {
        return ResponseEntity.ok(bookService.findBookDetailsByID(id));
    }

}
